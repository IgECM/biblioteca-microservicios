package com.biblioteca.ms_prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MsPrestamosApplication {
    public static void main(String[] args) {

        SpringApplication.run(
                MsPrestamosApplication.class,
                args
        );
    }

    // lo de aca permite hacer llamadas entre los dos microservicios y si dios lo permite no se CAEN
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}