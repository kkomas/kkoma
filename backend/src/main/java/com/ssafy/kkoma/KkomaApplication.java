package com.ssafy.kkoma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KkomaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkomaApplication.class, args);
    }

}
