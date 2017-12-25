package com.zzr;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ribbon 负载均衡rule
 * @author: zzr
 * @date: 2017/12/25 23:43
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {

    @Autowired
    private IClientConfig config;

    @Bean
    @ConditionalOnMissingBean
    public IRule ribbonRule(IClientConfig config) {
        // 随机的规则  （默认是轮询的方式）
        return new RandomRule();
    }
}
