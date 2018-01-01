package config;

import feign.Contract;
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
}
