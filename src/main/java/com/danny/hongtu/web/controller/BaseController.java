package com.danny.hongtu.web.controller;

import com.danny.hongtu.util.JsonResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author danny
 */
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST}, origins = "*")
public abstract class BaseController {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult exceptionHandle(Exception e){
        e.printStackTrace();
        return JsonResult.get(e);
    }
}
