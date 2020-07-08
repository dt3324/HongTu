package com.danny.hongtu.service.impl;

import com.danny.hongtu.application.MyRedisClient;
import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FactionDetailBean;
import com.danny.hongtu.dao.FactionDao;
import com.danny.hongtu.mapper.FactionMapper;
import com.danny.hongtu.service.FactionService;
import com.mongodb.BasicDBObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author danny
 */
@Service
public class FactionServiceImpl implements FactionService {
    @Resource
    private MyRedisClient myRedisClient;
    @Resource
    private FactionDao factionDao;
    @Resource
    private FactionMapper factionMapper;
    @Override
    public void insertOne(){
        FactionDetailBean factionDetailBean = new FactionDetailBean();
        factionDetailBean.setNewCatalogue("第五十八章大比（上）");
        factionDetailBean.setSynopsis("杜宇是杜国九皇子因为重生，自小不喜欢皇宫生活，于是逃出来。");
        factionDetailBean.setTotalSize("189219");
        factionDetailBean.setFactionClassify("传统武侠");
        factionDetailBean.setFactionName("指点江山之江湖争霸");
        factionDetailBean.setFactionUser("杜沐泽");
        factionDetailBean.setCoverImg("E:\\test\\demo\\Search_Down\\img\\663070.html");
        factionMapper.insertOne(factionDetailBean);
    }

    @Override
    public void findAll(){
        System.out.println(factionMapper.findAll());
    }

    @Override
    public List<FactionDetailBean> findFactionList(String factionName, String factionUser) {
        String keyName = "factionList" + factionName + factionUser;
        List<FactionDetailBean> factionList1 = (List<FactionDetailBean>) myRedisClient.get(keyName);
        if (factionList1 != null && factionList1.size() > 0) {
            return factionList1;
        }
        BasicDBObject queryParam = new BasicDBObject();
        if (factionName != null && !"".equals(factionName)) {
            Pattern compile = Pattern.compile("^.*" + factionName + ".*$");
            queryParam.append("factionName", compile);
        }
        if (factionUser != null && !"".equals(factionUser)) {
            Pattern compile = Pattern.compile("^.*" + factionUser + ".*$");
            queryParam.append("factionUser", compile);
        }
        List<FactionDetailBean> factionList = factionDao.findFactionList(queryParam);
        myRedisClient.set(keyName, factionList, 86400L);
        return factionList;
    }

    @Override
    public List<CatalogueBean> findFactionCatalogue(String factionName, String factionUser) {
        String keyName = "factionCatalogue" + factionName + factionUser;
        List<CatalogueBean> factionList1 = (List<CatalogueBean>) myRedisClient.get(keyName);
        if (factionList1 != null && factionList1.size() > 0) {
            return factionList1;
        }
        BasicDBObject queryParam = new BasicDBObject();
        if (factionName == null || "".equals(factionName)) {
            throw new RuntimeException("小说名不能为空");
        }
        if (factionUser == null || "".equals(factionUser)) {
            throw new RuntimeException("小说作者不能为空");
        }
        queryParam.append("factionName", factionName);
        queryParam.append("factionUser", factionUser);
        List<CatalogueBean> beanList = factionDao.findFactionCatalogue(queryParam, new BasicDBObject("id", 1));
        myRedisClient.set(keyName, beanList, 86400L);
        return beanList;
    }

    @Override
    public ContentBean findFactionContent(String factionName, String factionUser, String chapterName) {
        String keyName = "factionContent" + factionName + factionUser + chapterName;
        ContentBean contentBean = (ContentBean) myRedisClient.get(keyName);
        if (contentBean != null) {
            return contentBean;
        }
        BasicDBObject queryParam = new BasicDBObject();
        if (factionName == null || "".equals(factionName)) {
            throw new RuntimeException("小说名不能为空");
        }
        if (factionUser == null || "".equals(factionUser)) {
            throw new RuntimeException("小说作者不能为空");
        }
        if (chapterName == null || "".equals(chapterName)) {
            throw new RuntimeException("小说章节名不能为空");
        }
        queryParam.append("factionName", factionName);
        queryParam.append("factionUser", factionUser);
        queryParam.append("chapterName", chapterName);
        ContentBean factionContent = factionDao.findFactionContent(queryParam);
        myRedisClient.set(keyName, factionContent, 86400L);
        return factionContent;
    }
}
