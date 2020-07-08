package com.danny.hongtu.bean;

import org.bson.Document;

/**
 * @author danny
 */
public class ContentBean {
    private Long length;
    private String factionName;
    private String factionUser;
    private String chapterName;
    private String chapterContent;
    private String chapterTxt;

    public static ContentBean getCatalogueBean(Document document){
        ContentBean catalogueBean = new ContentBean();
        catalogueBean.setLength(Long.valueOf(document.getInteger("length")));
        catalogueBean.setChapterName(document.getString("chapterName"));
        catalogueBean.setFactionName(document.getString("factionName"));
        catalogueBean.setFactionUser(document.getString("factionUser"));
        catalogueBean.setChapterContent(document.getString("chapterContent"));
        catalogueBean.setChapterTxt(document.getString("chapterTxt"));
        return catalogueBean;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
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

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    public String getChapterTxt() {
        return chapterTxt;
    }

    public void setChapterTxt(String chapterTxt) {
        this.chapterTxt = chapterTxt;
    }

    @Override
    public String toString() {
        return "ContentBean{" +
                "length=" + length +
                ", factionName='" + factionName + '\'' +
                ", factionUser='" + factionUser + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterContent='" + chapterContent + '\'' +
                ", chapterTxt='" + chapterTxt + '\'' +
                '}';
    }
}
