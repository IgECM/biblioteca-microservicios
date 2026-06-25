package com.biblioteca.ms_prestamos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoRequestDTO {
    private Long usuarioId;
    private Long libroId;
    private String fechaPrestamo;
}
