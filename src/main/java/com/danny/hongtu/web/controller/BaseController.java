package com.danny.hongtu.web.controller;

import com.danny.hongtu.util.JsonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author danny
 */
@ControllerAdvice
public class BaseController {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult<String> exceptionHandle(Exception e){
        e.printStackTrace();
        return new JsonResult<String>().get(e.getMessage());
    }
}
