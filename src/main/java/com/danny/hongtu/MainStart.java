package com.danny.hongtu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author danny
 */
@SpringBootApplication
@MapperScan("com.danny.hongtu.mapper")
public class MainStart {
    public static void main(String[] args) {
        SpringApplication.run(MainStart.class);
    }
}
