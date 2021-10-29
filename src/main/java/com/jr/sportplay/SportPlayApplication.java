package com.jr.sportplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jr.sportplay.dao")
public class SportPlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportPlayApplication.class, args);
    }

}
