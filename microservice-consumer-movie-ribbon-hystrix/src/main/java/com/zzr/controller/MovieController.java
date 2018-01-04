package com.zzr.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zzr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 电影控制类
 * @author: zzr
 * @date: 2017/12/24 10:45
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findAllUser(@PathVariable Long id){
      return restTemplate.getForObject("http://microservice-provider-user/findById/"+id,User.class);
    }


    public User findByIdFallback(Long id){
        User user = new User();
        user.setName("aaa");
        return user;
    }
}
