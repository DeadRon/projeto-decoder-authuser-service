package com.ead.authuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//sinaliza para o spring cloud que esta aplicação será um client eureka pondendo registrar a aplicação no service registry
@EnableEurekaClient
public class AuthuserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthuserApplication.class, args);
    }

}
