package com.dyq.springcloud.seata.storage.service2002;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.dyq.springcloud.seata.storage.service2002.dao"})
public class SeataStorageService2002Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002Application.class, args);
    }

}
