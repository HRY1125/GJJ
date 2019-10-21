package com.zlk.gjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zlk.gjj.registerAndAccount.*.mapper")
public class GjjApplication {

    public static void main(String[] args) {
        SpringApplication.run(GjjApplication.class, args);
    }

}
