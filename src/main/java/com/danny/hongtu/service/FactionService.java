package com.danny.hongtu.service;

import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FactionDetailBean;
import org.bson.Document;

import java.util.List;

/**
 * @author fanny
 */
public interface FactionService {
    void findAll();
    void insertOne();
    /**
     * 查询小说列表
     * @param factionName 小说名字 可能有同名
     * @param factionUser 作者
     * @return 返回小说集合
     */
    List<FactionDetailBean> findFactionList(String factionName, String factionUser);

    /**
     * 查询章节列表
     * @param factionName 小说名字
     * @param factionUser 小说作者
     * @return 章节列表
     */
    List<CatalogueBean> findFactionCatalogue(String factionName, String factionUser);

    /**
     * 查询章节内容
     * @param factionName 小说名
     * @param factionUser 作者
     * @param chapterName 章节名
     * @return 章节内容
     */
    ContentBean findFactionContent(String factionName, String factionUser, String chapterName);
}
