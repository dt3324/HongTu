package com.danny.hongtu.web.controller;

import com.danny.hongtu.bean.CatalogueBean;
import com.danny.hongtu.bean.ContentBean;
import com.danny.hongtu.bean.FictionDetailBean;
import com.danny.hongtu.service.FictionService;
import com.danny.hongtu.util.JsonResult;
import io.swagger.annotations.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/fiction")
@Api(value = "小说信息接口")
public class FictionController extends BaseController{

    @Resource
    private FictionService fictionService;

    //获取参数
    @ApiImplicitParams({
            //name:参数名 paramType:query请求参数@RequestParam，header 请求头参数@ResquestHeader value:参数名 dataType:参数类型 required:是否必填
            @ApiImplicitParam(name = "fictionUser", paramType = "query", value = "作者",required = false),
            @ApiImplicitParam(name = "fictionName", paramType = "query", value = "小说名", required = false)
    })
    //用于表示一组响应
    @ApiResponses({
            //code状态 message信息
            @ApiResponse(code = 401,message = "你没有权限"),
            @ApiResponse(code = 403,message = "你被禁止访问了"),
            @ApiResponse(code = 404,message = "没找到，哈哈哈")
    })
    @PostMapping("/fictionList")
    @ApiOperation(value = "查询小说列表",notes = "查询小说列表")
    public JsonResult findFictionList(@RequestParam(required = false) String fictionName,@RequestParam(required = false) String fictionUser){
        List<FictionDetailBean> list = fictionService.findFictionList(fictionName,fictionUser);
        return JsonResult.get(list);
    }

    //获取参数
    @ApiImplicitParams({
            //name:参数名 paramType:query请求参数@RequestParam，header 请求头参数@ResquestHeader value:参数名 dataType:参数类型 required:是否必填
            @ApiImplicitParam(name = "fictionUser", paramType = "query", value = "作者",required = true),
            @ApiImplicitParam(name = "fictionName", paramType = "query", value = "小说名", required = true)
    })
    @PostMapping("/fictionCatalogue")
    @ApiOperation(value = "查询小说章节列表",notes = "查询小说章节列表")
    public JsonResult findFictionCatalogue(@RequestParam String fictionName,@RequestParam String fictionUser){
        List<CatalogueBean> list = fictionService.findFictionCatalogue(fictionName,fictionUser);
        return JsonResult.get(list);
    }

    //获取参数
    @ApiImplicitParams({
            //name:参数名 paramType:query请求参数@RequestParam，header 请求头参数@ResquestHeader value:参数名 dataType:参数类型 required:是否必填
            @ApiImplicitParam(name = "fictionUser", paramType = "query", value = "作者",required = true),
            @ApiImplicitParam(name = "fictionName", paramType = "query", value = "小说名", required = true),
            @ApiImplicitParam(name = "chapterName", paramType = "query", value = "小说章节名", required = true)
    })
    @PostMapping("/fictionContent")
    @ApiOperation(value = "查询小说章节内容",notes = "查询小说章节内容")
    public JsonResult findFictionContent(@RequestParam String fictionName,@RequestParam String fictionUser,@RequestParam String chapterName){
        ContentBean contentBean = fictionService.findFictionContent(fictionName,fictionUser,chapterName);
        return JsonResult.get(contentBean);
    }
}
