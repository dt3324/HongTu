package com.danny.hongtu.dao.impl;

import com.danny.hongtu.application.MyMongoClient;
import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FictionDetailBean;
import com.danny.hongtu.dao.FictionDao;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danny
 */
@Component
public class FictionDaoImpl implements FictionDao {
    @Override
    public List<FictionDetailBean> findFictionList(BasicDBObject queryParam) {
        FindIterable<Document> documents = MyMongoClient.getFictionDetailClient().find(queryParam);
        ArrayList<FictionDetailBean> result = new ArrayList<>();
        for (Document document : documents) {
            result.add(FictionDetailBean.getFictionDetailBean(document));
        }
        return result;
    }

    @Override
    public List<CatalogueBean> findFictionCatalogue(BasicDBObject queryParam, BasicDBObject sort) {
        FindIterable<Document> documents = MyMongoClient.getFictionCatalogueClient().find(queryParam).sort(sort);
        ArrayList<CatalogueBean> catalogueBeans = new ArrayList<>();
        for (Document document : documents) {
            catalogueBeans.add(CatalogueBean.getCatalogueBean(document));
        }
        return catalogueBeans;
    }

    @Override
    public ContentBean findFictionContent(BasicDBObject queryParam) {
        FindIterable<Document> documents = MyMongoClient.getFictionContentClient().find(queryParam).limit(1);
        ContentBean contentBean = null;
        for (Document document : documents) {
            contentBean = ContentBean.getCatalogueBean(document);
        }
        return contentBean;
    }
}
