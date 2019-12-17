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
        mongoTemplate = new MongoTemplate(new MongoClient("192.168.99.115", 27017), "fiction");
    }
    public static MongoTemplate getMongoTemplate(){
        return mongoTemplate;
    }

    /**
     * 获取fiction库 fictionCatalogue 表的Client
     * @return MongoCollection
     */
    public static MongoCollection<Document> getFictionCatalogueClient(){

        return mongoTemplate.getCollection("fictionCatalogue");
    }

    /**
     * 获取fiction库 fictionContent 表的Client
     * @return MongoCollection
     */
    public static MongoCollection<Document> getFictionContentClient(){
        return mongoTemplate.getCollection("fictionContent");
    }

    /**
     * 获取fiction库 fictionDetail 表的Client
     * @return MongoCollection
     */
    public static MongoCollection<Document> getFictionDetailClient(){
        return mongoTemplate.getCollection("fictionDetail");
    }

}
