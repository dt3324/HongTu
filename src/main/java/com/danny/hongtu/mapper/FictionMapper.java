package com.danny.hongtu.mapper;

import com.danny.hongtu.bean.FictionDetailBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author danny
 */
public interface FictionMapper {

    /**
     * 插入一条数据
     * @param fictionDetailBean 插入详情
     */
    void insertOne(FictionDetailBean fictionDetailBean);

    /**
     * 查询所有
     */
    List<FictionDetailBean> findAll();
}
