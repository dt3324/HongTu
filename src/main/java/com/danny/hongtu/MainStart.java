package com.danny.hongtu;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author danny
 */
@SpringBootApplication(exclude = { DruidDataSourceAutoConfigure.class })
@MapperScan("com.danny.hongtu.mapper")
public class MainStart {
    public static void main(String[] args) {
        SpringApplication.run(MainStart.class);
    }
}
