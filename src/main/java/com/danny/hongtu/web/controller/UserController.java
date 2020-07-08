package com.danny.hongtu.web.controller;

import com.danny.hongtu.bean.User;
import com.danny.hongtu.mapper.UserMapper;
import com.danny.hongtu.service.UserService;
import com.danny.hongtu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author danny
 */
@RestController
@RequestMapping("/user")
public class UserController{

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping("/findAll")
    public JsonResult findFactionContent(@RequestParam String username){
        List<User> users = userMapper.findAll();
        return JsonResult.get(users);
    }
    @PostMapping("/login")
    public JsonResult login(HttpServletResponse res, @RequestParam String username, @RequestParam String password){
        User u = userService.login(username,password,res);
        return JsonResult.get("登录成功");
    }

}
