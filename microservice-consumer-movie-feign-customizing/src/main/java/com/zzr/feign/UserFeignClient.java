package com.zzr.feign;

import com.zzr.entity.User;
import config.FeignConfiguration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.security.auth.login.Configuration;

/**
 * @description:
 * @author: zzr
 * @date: 2017/12/31 9:22
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration1.class)
public interface UserFeignClient {

    @RequestLine("GET /findById/{id}")
    public User findUserById(@Param("id") Long id);
}
