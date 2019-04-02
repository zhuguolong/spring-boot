package com.zhu.springboot.contorller;

import com.zhu.springboot.exception.ServiceException;
import com.zhu.springboot.utils.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(value = HttpStatus.MULTI_STATUS)
    public Object multipartExceptionHandler(MultipartException e) {
        String code = "000" + HttpStatus.MULTI_STATUS.value();
        return ResultMap.err(code, "图片上传失败，请稍候再试！");
    }

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object serviceExceptionHandler(ServiceException ex) {
        String code = "000" + HttpStatus.MULTI_STATUS.value();
        return ResultMap.err(code, "服务器繁忙，请稍候再试！");
    }
}
