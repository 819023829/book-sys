package com.book.common.exception;

import com.book.common.lang.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zcz
 * @created 2022/9/19 10:27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult runtimeException(RuntimeException e){
        e.printStackTrace();
         return AjaxResult.error(e.getMessage());
    }
}
