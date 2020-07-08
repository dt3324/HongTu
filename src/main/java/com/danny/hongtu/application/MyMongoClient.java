package com.danny.hongtu.application;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author admin
 */
public class MyMongoClient {
    private static MongoTemplate mongoTemplate;
    static {
        mongoTemplate = new MongoTemplate(new MongoClient("192.168.99.115", 27017), "faction");
    }
    public static MongoTemplate getMongoTemplate(){
        return mongoTemplate;
    }

    /**
     * 获取faction库 factionCatalogue 表的Client
     * @return MongoCollection
     */
    public static MongoCollection<Document> getFactionCatalogueClient(){

        return mongoTemplate.getCollection("factionCatalogue");
    }

    /**
     * 获取faction库 factionContent 表的Client
     * @return MongoCollection
     */
    public static MongoCollection<Document> getFactionContentClient(){
        return mongoTemplate.getCollection("factionContent");
    }

    /**
     * 获取faction库 factionDetail 表的Client
     * @return MongoCollection
     */
    public static MongoCollection<Document> getFactionDetailClient(){
        return mongoTemplate.getCollection("factionDetail");
    }

}
