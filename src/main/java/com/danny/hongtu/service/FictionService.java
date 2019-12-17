package com.danny.hongtu.service;

import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FictionDetailBean;
import org.bson.Document;

import java.util.List;

/**
 * @author fanny
 */
public interface FictionService {
    void findAll();
    void insertOne();
    /**
     * 查询小说列表
     * @param fictionName 小说名字 可能有同名
     * @param fictionUser 作者
     * @return 返回小说集合
     */
    List<FictionDetailBean> findFictionList(String fictionName, String fictionUser);

    /**
     * 查询章节列表
     * @param fictionName 小说名字
     * @param fictionUser 小说作者
     * @return 章节列表
     */
    List<CatalogueBean> findFictionCatalogue(String fictionName, String fictionUser);

    /**
     * 查询章节内容
     * @param fictionName 小说名
     * @param fictionUser 作者
     * @param chapterName 章节名
     * @return 章节内容
     */
    ContentBean findFictionContent(String fictionName, String fictionUser, String chapterName);
}
