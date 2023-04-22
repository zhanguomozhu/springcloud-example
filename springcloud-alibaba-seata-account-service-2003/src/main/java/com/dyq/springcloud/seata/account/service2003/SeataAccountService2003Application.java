package com.dyq.springcloud.seata.account.service2003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.dyq.springcloud.seata.account.service2003.dao"})
public class SeataAccountService2003Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService2003Application.class, args);
    }

}
