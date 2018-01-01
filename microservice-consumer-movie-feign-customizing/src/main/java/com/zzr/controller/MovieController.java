package com.zzr.controller;

import com.zzr.entity.User;
import com.zzr.feign.UserFeignClient;
import com.zzr.feign.UserFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 电影控制类
 * @author: zzr
 * @date: 2017/12/24 10:45
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignClient2 userFeignClient2;

    @GetMapping(value = "/user/{id}")
    public User findAllUser(@PathVariable Long id){
      return userFeignClient.findUserById(id);
    }

    @GetMapping("/{servicename}")
    public String findServiceInfoByServicename(@PathVariable String servicename){
        return userFeignClient2.findServiceInfoByServicename(servicename);
    }

}
