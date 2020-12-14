package com.foodnav;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描dao文件夹
@MapperScan("com.foodnav.dao")
@SpringBootApplication
public class FoodnavApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodnavApplication.class, args);
    }

}
