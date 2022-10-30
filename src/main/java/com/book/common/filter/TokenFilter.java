package com.book.common.filter;

import com.book.common.lang.PublicUrlConfig;
import com.book.common.lang.UserTokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;


/**
 * @author zcz
 * @created 2022/9/20 10:03
 */
//@Component
//@Order(1)
public class TokenFilter implements Filter {


    @Autowired
    private PublicUrlConfig publicUrlConfig;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("init");
        System.err.println(publicUrlConfig.getUrl());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.err.println("doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        String token = request.getHeader("token");

        for (String s : publicUrlConfig.getUrl()) {
            if (Pattern.matches(s,uri)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (token == null) {
            throw new RuntimeException("header not existed token");
        } else if (UserTokenInfo.TokenPool.get(token) != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            throw new RuntimeException("bad token");}

    }

    @Override
    public void destroy() {
        System.err.println("destroy");
    }
}
