package com.book.common.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 解决filter全局异常，重写error页面
 * @author zcz
 * @created 2022/9/20 18:56
 */
@RestController
public class ErrorControllerImpl implements ErrorController {
    @RequestMapping("/error")
    public void HandlerError(HttpServletRequest request) throws Throwable{
        if (request.getAttribute("javax.servlet.error.exception") != null){
            throw (Throwable) request.getAttribute("javax.servlet.error.exception");
        }
    }
}
