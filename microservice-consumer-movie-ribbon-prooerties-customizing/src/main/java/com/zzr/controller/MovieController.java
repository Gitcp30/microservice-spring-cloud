package com.zzr.controller;

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
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/user/{id}")
    public User findAllUser(@PathVariable Long id){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("===:" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        return restTemplate.getForObject("http://microservice-provider-user2/findById/"+id,User.class);
    }

    @GetMapping(value = "/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println("111:" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("222:" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort() );

        return  "1";

    }

}
