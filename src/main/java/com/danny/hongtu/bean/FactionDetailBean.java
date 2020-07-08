package com.danny.hongtu.bean;

import org.bson.Document;

import java.io.Serializable;

/**
 * @author danny
 */
public class FactionDetailBean implements Serializable {
    private String factionName;
    private String factionUser;
    private String factionClassify;
    private String totalSize;
    private String synopsis;
    private String newCatalogue;
    private String coverImg;

    public static FactionDetailBean getFactionDetailBean(Document document){
        FactionDetailBean factionDetailBean = new FactionDetailBean();
        factionDetailBean.setCoverImg(document.getString("coverImg"));
        factionDetailBean.setFactionName(document.getString("factionName"));
        factionDetailBean.setFactionUser(document.getString("factionUser"));
        factionDetailBean.setFactionClassify(document.getString("factionClassify"));
        factionDetailBean.setTotalSize(document.getString("totalSize"));
        factionDetailBean.setSynopsis(document.getString("synopsis"));
        factionDetailBean.setNewCatalogue(document.getString("newCatalogue"));
        return factionDetailBean;
    }

    @Override
    public String toString() {
        return "FactionDetailBean{" +
                "factionName='" + factionName + '\'' +
                ", factionUser='" + factionUser + '\'' +
                ", factionClassify='" + factionClassify + '\'' +
                ", totalSize='" + totalSize + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", newCatalogue='" + newCatalogue + '\'' +
                ", coverImg='" + coverImg + '\'' +
                '}';
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
