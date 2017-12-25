package com.zzr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-provider-user",configuration = TestConfiguration.class)
/**
 * 1、扫描包的排除：
 @Configuration这个注解是不能@SpringBootApplication的所在扫描到的，
 否则将自定义的配置将失效。所以需要将TestConfiguration.java排除在包扫描之外，
 用自定义的注解@ExcludeFromComponentScan，
 然后在启动类加注解@ComponentScan(excludeFilters{@ComponentScan.Filter(type=FilterType.ANNOTATION,value=ExcludeFromComponentScan.class)})
 将其排除。
 */
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
// 使用 TestConfiguration的规则
public class MicroserviceConsumerMovieRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}
