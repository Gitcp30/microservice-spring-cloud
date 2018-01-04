package config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: zzr
 * @date: 2018/01/01 23:28
 */
@Configuration
public class FeignConfiguration1 {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    // 日志的打印级别
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
