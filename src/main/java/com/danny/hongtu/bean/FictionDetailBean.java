package com.danny.hongtu.bean;

import org.bson.Document;

import java.io.Serializable;

/**
 * @author danny
 */
public class FictionDetailBean implements Serializable {
    private String fictionName;
    private String fictionUser;
    private String fictionClassify;
    private String totalSize;
    private String synopsis;
    private String newCatalogue;
    private String coverImg;

    public static FictionDetailBean getFictionDetailBean(Document document){
        FictionDetailBean fictionDetailBean = new FictionDetailBean();
        fictionDetailBean.setCoverImg(document.getString("coverImg"));
        fictionDetailBean.setFictionName(document.getString("fictionName"));
        fictionDetailBean.setFictionUser(document.getString("fictionUser"));
        fictionDetailBean.setFictionClassify(document.getString("fictionClassify"));
        fictionDetailBean.setTotalSize(document.getString("totalSize"));
        fictionDetailBean.setSynopsis(document.getString("synopsis"));
        fictionDetailBean.setNewCatalogue(document.getString("newCatalogue"));
        return fictionDetailBean;
    }

    @Override
    public String toString() {
        return "FictionDetailBean{" +
                "fictionName='" + fictionName + '\'' +
                ", fictionUser='" + fictionUser + '\'' +
                ", fictionClassify='" + fictionClassify + '\'' +
                ", totalSize='" + totalSize + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", newCatalogue='" + newCatalogue + '\'' +
                ", coverImg='" + coverImg + '\'' +
                '}';
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

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getNewCatalogue() {
        return newCatalogue;
    }

    public void setNewCatalogue(String newCatalogue) {
        this.newCatalogue = newCatalogue;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }
}
