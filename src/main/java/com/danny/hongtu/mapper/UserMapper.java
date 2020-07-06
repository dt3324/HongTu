package com.danny.hongtu.mapper;

import com.danny.hongtu.bean.FictionDetailBean;
import com.danny.hongtu.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author danny
 */
@Mapper
public interface UserMapper {

    /**
     * 插入一条数据
     * @param user 插入详情
     */
    void insertOne(User user);

    /**
     * 查询所有
     */
    List<User> findAll();

    User login(String username, String password);
}
