package com.zzr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: zzr
 * @date: 2017/12/24 10:55
 */
@Configuration
public class JavaConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
