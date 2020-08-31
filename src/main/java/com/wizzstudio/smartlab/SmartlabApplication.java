package com.wizzstudio.smartlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@EnableJpaAuditing
public class SmartlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartlabApplication.class, args);
    }

}
