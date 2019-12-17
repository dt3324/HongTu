package com.danny.hongtu.bean;

import org.bson.Document;

/**
 * @author danny
 */
public class CatalogueBean {
    private Long id;
    private String fictionName;
    private String fictionUser;
    private String fictionClassify;
    private String fictionClassifyChild;
    private String synopsis;
    private String lastTime;
    private String chapterUrl;
    private String chapterName;

    public static CatalogueBean getCatalogueBean(Document document){
        CatalogueBean catalogueBean = new CatalogueBean();
        catalogueBean.setId(Long.valueOf(document.getInteger("id")));
        catalogueBean.setChapterName(document.getString("chapterName"));
        catalogueBean.setFictionName(document.getString("fictionName"));
        catalogueBean.setFictionUser(document.getString("fictionUser"));
        catalogueBean.setFictionClassify(document.getString("fictionClassify"));
        catalogueBean.setFictionClassifyChild(document.getString("fictionClassifyChild"));
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

    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName;
    }

    public String getFictionUser() {
        return fictionUser;
    }

    public void setFictionUser(String fictionUser) {
        this.fictionUser = fictionUser;
    }

    public String getFictionClassify() {
        return fictionClassify;
    }

    public void setFictionClassify(String fictionClassify) {
        this.fictionClassify = fictionClassify;
    }

    public String getFictionClassifyChild() {
        return fictionClassifyChild;
    }

    public void setFictionClassifyChild(String fictionClassifyChild) {
        this.fictionClassifyChild = fictionClassifyChild;
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
                ", fictionName='" + fictionName + '\'' +
                ", fictionUser='" + fictionUser + '\'' +
                ", fictionClassify='" + fictionClassify + '\'' +
                ", fictionClassifyChild='" + fictionClassifyChild + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", chapterUrl='" + chapterUrl + '\'' +
                ", chapterName='" + chapterName + '\'' +
                '}';
    }
}
