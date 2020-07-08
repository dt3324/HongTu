package com.danny.hongtu.mapper;

import com.danny.hongtu.bean.FactionDetailBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author danny
 */
@Mapper
public interface FactionMapper {

    /**
     * 插入一条数据
     * @param factionDetailBean 插入详情
     */
    void insertOne(FactionDetailBean factionDetailBean);

    /**
     * 查询所有
     */
    List<FactionDetailBean> findAll();
}
