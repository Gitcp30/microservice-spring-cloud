package com.zzr.repository;

import com.zzr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: 用户持久化类
 * @author: zzr
 * @date: 2017/12/24 10:31
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
