package com.danny.hongtu.web.controller;

import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FactionDetailBean;
import com.danny.hongtu.service.FactionService;
import com.danny.hongtu.util.JsonResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author danny
 */
@RestController
@RequestMapping("/faction")
@Api(value = "小说信息接口")
public class FactionController {

    @Resource
    private FactionService factionService;

    //获取参数
    @ApiImplicitParams({
            //name:参数名 paramType:query请求参数@RequestParam，header 请求头参数@ResquestHeader value:参数名 dataType:参数类型 required:是否必填
            @ApiImplicitParam(name = "factionUser", paramType = "query", value = "作者",required = false),
            @ApiImplicitParam(name = "factionName", paramType = "query", value = "小说名", required = false)
    })
    //用于表示一组响应
    @ApiResponses({
            //code状态 message信息
            @ApiResponse(code = 401,message = "你没有权限"),
            @ApiResponse(code = 403,message = "你被禁止访问了"),
            @ApiResponse(code = 404,message = "没找到，哈哈哈")
    })
    @RequestMapping("/factionList")
    @ApiOperation(value = "查询小说列表",notes = "查询小说列表")
    public JsonResult<List<FactionDetailBean>> findFactionList(@RequestParam(required = false) String factionName,@RequestParam(required = false) String factionUser){
        List<FactionDetailBean> list = factionService.findFactionList(factionName,factionUser);
        FactionDetailBean factionDetailBean = new FactionDetailBean();
        factionDetailBean.setFactionUser("aaaaaaaaaaaaaaaa");
        factionDetailBean.setFactionName("bbbbbbbbbbbbbbbbbbb");
        list.add(factionDetailBean);
        return new JsonResult<List<FactionDetailBean>>().get(list);
    }

    //获取参数
    @ApiImplicitParams({
            //name:参数名 paramType:query请求参数@RequestParam，header 请求头参数@ResquestHeader value:参数名 dataType:参数类型 required:是否必填
            @ApiImplicitParam(name = "factionUser", paramType = "query", value = "作者",required = true),
            @ApiImplicitParam(name = "factionName", paramType = "query", value = "小说名", required = true)
    })
    @PostMapping("/factionCatalogue")
    @ApiOperation(value = "查询小说章节列表",notes = "查询小说章节列表")
    public JsonResult<List<CatalogueBean>> findFactionCatalogue(@RequestParam String factionName,@RequestParam String factionUser){
        List<CatalogueBean> list = factionService.findFactionCatalogue(factionName,factionUser);
        return new JsonResult<List<CatalogueBean>>().get(list);
    }

    //获取参数
    @ApiImplicitParams({
            //name:参数名 paramType:query请求参数@RequestParam，header 请求头参数@ResquestHeader value:参数名 dataType:参数类型 required:是否必填
            @ApiImplicitParam(name = "factionUser", paramType = "query", value = "作者",required = true),
            @ApiImplicitParam(name = "factionName", paramType = "query", value = "小说名", required = true),
            @ApiImplicitParam(name = "chapterName", paramType = "query", value = "小说章节名", required = true)
    })
    @PostMapping("/factionContent")
    @ApiOperation(value = "查询小说章节内容",notes = "查询小说章节内容")
    public JsonResult<ContentBean> findFactionContent(@RequestParam String factionName,@RequestParam String factionUser,@RequestParam String chapterName){
        ContentBean contentBean = factionService.findFactionContent(factionName,factionUser,chapterName);
        return new JsonResult<ContentBean>().get(contentBean);
    }
}
