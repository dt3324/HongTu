package com.danny.hongtu.dao;

import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FictionDetailBean;
import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.util.List;

/**
 * @author danny
 */
public interface FictionDao {
    /**
     * 查询小说列表
     * @param queryParam  查询条件
     * @return 查询结果
     */
    List<FictionDetailBean> findFictionList(BasicDBObject queryParam);

    /**
     * 查询小说列表
     * @param queryParam 查询条件
     * @param sort 排序规则
     * @return 查询结果
     */
    List<CatalogueBean> findFictionCatalogue(BasicDBObject queryParam, BasicDBObject sort);

    /**
     * 查询章节内容
     * @param queryParam 条件
     * @return 章节内容
     */
    ContentBean findFictionContent(BasicDBObject queryParam);
}
