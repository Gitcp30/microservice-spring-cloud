package com.zzr.feign;

import config.FeignConfiguration2;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: zzr
 * @date: 2018/01/01 23:45
 */
@FeignClient(name="xxxx",url = "http://127.0.0.1:8761/", configuration = FeignConfiguration2.class)
public interface UserFeignClient2 {

    @RequestMapping(value = "eureka/apps/{servicename}")
    public String findServiceInfoByServicename(@PathVariable("servicename") String servicename);
}
