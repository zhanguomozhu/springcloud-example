package com.dyq.springcloud.openfeign.order84.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig
{

    /**
     * 开启openfeign日志
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}

