package com.hdsx.webservice.multimedia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaServer
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@Configuration
@EnableSwagger2
public class MultimediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultimediaApplication.class, args);
    }
}
