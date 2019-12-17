package com.danny.hongtu.service.impl;

import com.danny.hongtu.application.MyRedisClient;
import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FictionDetailBean;
import com.danny.hongtu.dao.FictionDao;
import com.danny.hongtu.mapper.FictionMapper;
import com.danny.hongtu.service.FictionService;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author danny
 */
@Service
public class FictionServiceImpl implements FictionService {
    @Resource
    private MyRedisClient myRedisClient;
    @Resource
    private FictionDao fictionDao;
    @Autowired
    private FictionMapper fictionMapper;
    @Override
    public void insertOne(){
        FictionDetailBean fictionDetailBean = new FictionDetailBean();
        fictionDetailBean.setNewCatalogue("第五十八章大比（上）");
        fictionDetailBean.setSynopsis("杜宇是杜国九皇子因为重生，自小不喜欢皇宫生活，于是逃出来。");
        fictionDetailBean.setTotalSize("189219");
        fictionDetailBean.setFictionClassify("传统武侠");
        fictionDetailBean.setFictionName("指点江山之江湖争霸");
        fictionDetailBean.setFictionUser("杜沐泽");
        fictionDetailBean.setCoverImg("E:\\test\\demo\\Search_Down\\img\\663070.html");
        fictionMapper.insertOne(fictionDetailBean);
    }

    @Override
    public void findAll(){
        System.out.println(fictionMapper.findAll());
    }

    @Override
    public List<FictionDetailBean> findFictionList(String fictionName, String fictionUser) {
        String keyName = "fictionList" + fictionName + fictionUser;
        List<FictionDetailBean> fictionList1 = (List<FictionDetailBean>) myRedisClient.get(keyName);
        if (fictionList1 != null && fictionList1.size() > 0) {
            return fictionList1;
        }
        BasicDBObject queryParam = new BasicDBObject();
        if (fictionName != null && !"".equals(fictionName)) {
            Pattern compile = Pattern.compile("^.*" + fictionName + ".*$");
            queryParam.append("fictionName", compile);
        }
        if (fictionUser != null && !"".equals(fictionUser)) {
            Pattern compile = Pattern.compile("^.*" + fictionUser + ".*$");
            queryParam.append("fictionUser", compile);
        }
        List<FictionDetailBean> fictionList = fictionDao.findFictionList(queryParam);
        myRedisClient.set(keyName, fictionList, 86400L);
        return fictionList;
    }

    @Override
    public List<CatalogueBean> findFictionCatalogue(String fictionName, String fictionUser) {
        String keyName = "fictionCatalogue" + fictionName + fictionUser;
        List<CatalogueBean> fictionList1 = (List<CatalogueBean>) myRedisClient.get(keyName);
        if (fictionList1 != null && fictionList1.size() > 0) {
            return fictionList1;
        }
        BasicDBObject queryParam = new BasicDBObject();
        if (fictionName == null || "".equals(fictionName)) {
            throw new RuntimeException("小说名不能为空");
        }
        if (fictionUser == null || "".equals(fictionUser)) {
            throw new RuntimeException("小说作者不能为空");
        }
        queryParam.append("fictionName", fictionName);
        queryParam.append("fictionUser", fictionUser);
        List<CatalogueBean> beanList = fictionDao.findFictionCatalogue(queryParam, new BasicDBObject("id", 1));
        myRedisClient.set(keyName, beanList, 86400L);
        return beanList;
    }

    @Override
    public ContentBean findFictionContent(String fictionName, String fictionUser, String chapterName) {
        String keyName = "fictionContent" + fictionName + fictionUser + chapterName;
        ContentBean contentBean = (ContentBean) myRedisClient.get(keyName);
        if (contentBean != null) {
            return contentBean;
        }
        BasicDBObject queryParam = new BasicDBObject();
        if (fictionName == null || "".equals(fictionName)) {
            throw new RuntimeException("小说名不能为空");
        }
        if (fictionUser == null || "".equals(fictionUser)) {
            throw new RuntimeException("小说作者不能为空");
        }
        if (chapterName == null || "".equals(chapterName)) {
            throw new RuntimeException("小说章节名不能为空");
        }
        queryParam.append("fictionName", fictionName);
        queryParam.append("fictionUser", fictionUser);
        queryParam.append("chapterName", chapterName);
        ContentBean fictionContent = fictionDao.findFictionContent(queryParam);
        myRedisClient.set(keyName, fictionContent, 86400L);
        return fictionContent;
    }
}
