package com.danny.hongtu.service.impl;

import com.danny.hongtu.bean.User;
import com.danny.hongtu.mapper.UserMapper;
import com.danny.hongtu.security.JwtField;
import com.danny.hongtu.service.JwtService;
import com.danny.hongtu.service.UserService;
import com.danny.hongtu.util.BuilderMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author danny
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtService jwtService;

    @Resource
    private JwtField jwtField;

    @Override
    public User login(String username, String password, HttpServletResponse response) {
//        User user = userMapper.login(username, password);
        User user = new User().setId(1L).setUsername(username).setPassword(password);
        Map<String, Object> bm = BuilderMap.of(String.class, Object.class)
                .put("userId", user.getId())
                .put("username", user.getUsername())
                .put("password", user.getPassword())
                .get();
        String token = getToken(bm);
        response.setHeader("Access-Control-Expose-Headers", "token");
        response.setHeader("token", token);
        return user;
    }

    private String getToken(Map<String, Object> map) {
        String token = null;
        try {
            token = jwtService.createJWT(map, jwtField.getTtlMillis());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return token;
    }
}
