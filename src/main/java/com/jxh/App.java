package com.jxh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author meizh
 */
@SpringBootApplication
@MapperScan("com.jxh.mapper")
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }
}
