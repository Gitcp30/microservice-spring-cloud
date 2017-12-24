package com.zzr.controller;

import com.zzr.entity.User;
import com.zzr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 用户控制类
 * @author: zzr
 * @date: 2017/12/23 16:44
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }


    @GetMapping("findById/{id}")
    public User findById (@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}
