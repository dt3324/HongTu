package com.danny.hongtu.dao;

import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FactionDetailBean;
import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.util.List;

/**
 * @author danny
 */
public interface FactionDao {
    /**
     * 查询小说列表
     * @param queryParam  查询条件
     * @return 查询结果
     */
    List<FactionDetailBean> findFactionList(BasicDBObject queryParam);

    /**
     * 查询小说列表
     * @param queryParam 查询条件
     * @param sort 排序规则
     * @return 查询结果
     */
    List<CatalogueBean> findFactionCatalogue(BasicDBObject queryParam, BasicDBObject sort);

    /**
     * 查询章节内容
     * @param queryParam 条件
     * @return 章节内容
     */
    ContentBean findFactionContent(BasicDBObject queryParam);
}
