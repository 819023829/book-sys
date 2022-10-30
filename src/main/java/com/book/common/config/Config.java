package com.book.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zcz
 * @created 2022/9/16 11:33
 */
@Configuration
@MapperScan("com.book.mbp.mapper")
public class Config {
}
