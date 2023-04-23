//springboot启动类
package com.lp;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lp.mapper")
@EnableTransactionManagement
public class Bugai001Application {
    public static void main(String[] args) {
        SpringApplication.run(Bugai001Application.class, args);
    }
}
