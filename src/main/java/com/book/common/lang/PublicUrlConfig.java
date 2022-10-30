package com.book.common.lang;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
/**
 * @author zcz
 * @created 2022/9/27 10:15
 */
@Configuration
@ConfigurationProperties("public")
public class PublicUrlConfig {
    private List<String> url;

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}