package com.aaa.cjk.ftp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈佳康
 * @date 2019-09-01 19:06
 */
@SpringBootApplication
@MapperScan("com.aaa.cjk.ftp.mapper")
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }

}
