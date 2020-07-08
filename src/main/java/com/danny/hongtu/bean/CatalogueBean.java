package com.danny.hongtu.bean;

import org.bson.Document;

/**
 * @author danny
 */
public class CatalogueBean {
    private Long id;
    private String factionName;
    private String factionUser;
    private String factionClassify;
    private String factionClassifyChild;
    private String synopsis;
    private String lastTime;
    private String chapterUrl;
    private String chapterName;

    public static CatalogueBean getCatalogueBean(Document document){
        CatalogueBean catalogueBean = new CatalogueBean();
        catalogueBean.setId(Long.valueOf(document.getInteger("id")));
        catalogueBean.setChapterName(document.getString("chapterName"));
        catalogueBean.setFactionName(document.getString("factionName"));
        catalogueBean.setFactionUser(document.getString("factionUser"));
        catalogueBean.setFactionClassify(document.getString("factionClassify"));
        catalogueBean.setFactionClassifyChild(document.getString("factionClassifyChild"));
        catalogueBean.setSynopsis(document.getString("synopsis"));
        catalogueBean.setLastTime(document.getString("lastTime"));
        catalogueBean.setChapterUrl(null);
        return catalogueBean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getFactionUser() {
        return factionUser;
    }

    public void setFactionUser(String factionUser) {
        this.factionUser = factionUser;
    }

    public String getFactionClassify() {
        return factionClassify;
    }

    public void setFactionClassify(String factionClassify) {
        this.factionClassify = factionClassify;
    }

    public String getFactionClassifyChild() {
        return factionClassifyChild;
    }

    public void setFactionClassifyChild(String factionClassifyChild) {
        this.factionClassifyChild = factionClassifyChild;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Override
    public String toString() {
        return "CatalogueBean{" +
                "id=" + id +
                ", factionName='" + factionName + '\'' +
                ", factionUser='" + factionUser + '\'' +
                ", factionClassify='" + factionClassify + '\'' +
                ", factionClassifyChild='" + factionClassifyChild + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", chapterUrl='" + chapterUrl + '\'' +
                ", chapterName='" + chapterName + '\'' +
                '}';
    }
}
