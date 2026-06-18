package com.biblioteca.ms_prestamos.client;

import com.biblioteca.ms_prestamos.dto.UsuarioDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UsuarioClient {

    private RestTemplate restTemplate;


    public UsuarioClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // llama al microservicio usuarios pero si no encuentra el usuario devuelve NULL
    public UsuarioDTO obtenerUsuario(Long id) {

        String url = "http://ms-usuarios:8081/usuarios/" + id;

        try {

            return restTemplate.getForObject(
                    url,
                    UsuarioDTO.class
            );

        } catch(Exception e) {

            return null;
        }
    }
}