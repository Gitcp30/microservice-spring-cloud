package com.zzr.controller;

import com.zzr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User findAllUser(@PathVariable Long id){
      return restTemplate.getForObject("http://127.0.0.1:7900/findById/"+id,User.class);
    }

}
