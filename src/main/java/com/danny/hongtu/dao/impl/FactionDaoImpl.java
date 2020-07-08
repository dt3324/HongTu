package com.danny.hongtu.dao.impl;

import com.danny.hongtu.application.MyMongoClient;
import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FactionDetailBean;
import com.danny.hongtu.dao.FactionDao;
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
public class FactionDaoImpl implements FactionDao {
    @Override
    public List<FactionDetailBean> findFactionList(BasicDBObject queryParam) {
        FindIterable<Document> documents = MyMongoClient.getFactionDetailClient().find(queryParam);
        ArrayList<FactionDetailBean> result = new ArrayList<>();
        for (Document document : documents) {
            result.add(FactionDetailBean.getFactionDetailBean(document));
        }
        return result;
    }

    @Override
    public List<CatalogueBean> findFactionCatalogue(BasicDBObject queryParam, BasicDBObject sort) {
        FindIterable<Document> documents = MyMongoClient.getFactionCatalogueClient().find(queryParam).sort(sort);
        ArrayList<CatalogueBean> catalogueBeans = new ArrayList<>();
        for (Document document : documents) {
            catalogueBeans.add(CatalogueBean.getCatalogueBean(document));
        }
        return catalogueBeans;
    }

    @Override
    public ContentBean findFactionContent(BasicDBObject queryParam) {
        FindIterable<Document> documents = MyMongoClient.getFactionContentClient().find(queryParam).limit(1);
        ContentBean contentBean = null;
        for (Document document : documents) {
            contentBean = ContentBean.getCatalogueBean(document);
        }
        return contentBean;
    }
}
