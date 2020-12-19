package com.cryptography;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Z_HAO
 */
@SpringBootApplication
@MapperScan("com.cryptography")

public class CryptographyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptographyApplication.class, args);
    }

}
