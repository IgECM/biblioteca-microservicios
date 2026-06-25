package com.biblioteca.ms_libros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDTO {
    private String titulo;
    private String autor;
    private Integer stock;
}
