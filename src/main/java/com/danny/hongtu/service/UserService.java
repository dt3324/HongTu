package com.danny.hongtu.service;

import com.danny.hongtu.bean.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @author fanny
 */
public interface UserService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param res
     * @return 用户的全部信息
     */
    User login(String username, String password, HttpServletResponse res);
}
