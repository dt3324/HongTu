package com.danny.hongtu.bean;

import org.bson.Document;

/**
 * @author danny
 */
public class ContentBean {
    private Long length;
    private String fictionName;
    private String fictionUser;
    private String chapterName;
    private String chapterContent;
    private String chapterTxt;

    public static ContentBean getCatalogueBean(Document document){
        ContentBean catalogueBean = new ContentBean();
        catalogueBean.setLength(Long.valueOf(document.getInteger("length")));
        catalogueBean.setChapterName(document.getString("chapterName"));
        catalogueBean.setFictionName(document.getString("fictionName"));
        catalogueBean.setFictionUser(document.getString("fictionUser"));
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
                ", fictionName='" + fictionName + '\'' +
                ", fictionUser='" + fictionUser + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterContent='" + chapterContent + '\'' +
                ", chapterTxt='" + chapterTxt + '\'' +
                '}';
    }
}
