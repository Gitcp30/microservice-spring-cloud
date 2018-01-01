package com.zzr.feign;

import com.zzr.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: zzr
 * @date: 2017/12/31 9:22
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {

    @GetMapping("findById/{id}")
    public User findUserById(@PathVariable("id") Long id);
}
