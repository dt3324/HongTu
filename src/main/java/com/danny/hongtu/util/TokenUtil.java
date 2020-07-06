package com.danny.hongtu.util;

import com.danny.hongtu.bean.Operation;
import com.danny.hongtu.service.JwtService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.danny.hongtu.util.ObjectUtil.getString;
import static com.danny.hongtu.util.StringUtils.getOldDepartmentCode;


/**
 * @author xhz
 * @version 1.0
 * @date 2019/8/2 17:45
 */
@Component
public class TokenUtil {

    private static JwtService jwtService;

    public TokenUtil(JwtService jwtService) {
        TokenUtil.jwtService = jwtService;
    }

    /**
     * 判断是否有相关功能
     *
     * @param request
     * @param operatorId
     * @return
     */
    public static boolean hasOperation(HttpServletRequest request, Integer operatorId) {
        Map<String, Object> chain = jwtService.parseJWT(request.getHeader("token"));
        List<Integer> operate = (List<Integer>) chain.get("operate");
        return operate != null && new HashSet<>(operate).contains(operatorId);
    }

    /**
     * 判断是否有所有输入的功能权限
     *
     * @param request
     * @param operatorIds
     * @return
     */
    public static boolean hasOperation(HttpServletRequest request, String operatorIds) {
        Map<String, Object> chain = jwtService.parseJWT(request.getHeader("token"));
        Set<Integer> tokenOperate = new HashSet<>((List<Integer>) chain.get("operate"));
        Set<Integer> set = new HashSet<>();
        Arrays.stream(operatorIds.split(",")).forEach(id -> set.add(Integer.valueOf(id)));
        return tokenOperate.containsAll(set);
    }


    /**
     * 判断是否有相关功能
     *
     * @param request
     * @param operation 功能枚举类型
     * @return
     */
    public static boolean hasOperation(HttpServletRequest request, Operation operation) {
        return hasOperation(request, operation.getOperationId());
    }

    /**
     * 获取用户departmentCode
     */
    public static String getDepartmentCode(HttpServletRequest request) {
        Map<String, Object> chain = jwtService.parseJWT(request.getHeader("token"));
        return getString(chain, "unit");
    }

    /**
     * 获取PoliceNumber
     */
    public static String getPoliceNumber(HttpServletRequest request) {
        Map<String, Object> chain = jwtService.parseJWT(request.getHeader("token"));
        return getString(chain, "police");
    }

    /**
     * 判断用户是否具有目标单位的查询权限
     *
     * @param request  HttpServletRequest
     * @param unitCode departmentCode
     * @return
     */
    public static boolean isAllowedUnit(HttpServletRequest request, String unitCode) {
        Map<String, Object> chain = jwtService.parseJWT(request.getHeader("token"));
        Set<String> units = new HashSet<>();
        units.add(getOldDepartmentCode(getString(chain, "unit")));
        List<String> license = (List<String>) (chain.get("license"));
        if (!CollectionUtils.isEmpty(license)) {
            units.addAll(license.stream().map(StringUtils::getOldDepartmentCode).collect(Collectors.toSet()));
        }
        return unitCode != null && units.stream().anyMatch(unitCode::startsWith);
    }

    /**
     * 判断用户是否具有目标单位的管理权限
     *
     * @param request  HttpServletRequest
     * @param unitCode departmentCode
     * @return
     */
    public static boolean isAllowedManageUnit(HttpServletRequest request, String unitCode) {
        String userUnit = getOldDepartmentCode(getDepartmentCode(request));
        return unitCode != null && unitCode.startsWith(userUnit);
    }

    /**
     * 判断用户是否具有超级管理员权限
     *
     * @param request
     * @return
     */
    public static boolean isSupperAdministrator(HttpServletRequest request) {
        Map<String, Object> chain = jwtService.parseJWT(request.getHeader("token"));
        Integer roleId = getInteger(chain, "roleId");
        return roleId != null && roleId.equals(3);
    }

    private static Integer getInteger(Map<? super String, ?> map, String key){
        Number answer = getNumber(map, key);
        if (answer == null) {
            return null;
        } else {
            return answer instanceof Integer ? (Integer)answer : answer.intValue();
        }
    }

    private static <K> Number getNumber(Map<? super K, ?> map, K key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                if (answer instanceof Number) {
                    return (Number)answer;
                }

                if (answer instanceof String) {
                    try {
                        String text = (String)answer;
                        return NumberFormat.getInstance().parse(text);
                    } catch (ParseException var4) {
                        ;
                    }
                }
            }
        }

        return null;
    }
}
