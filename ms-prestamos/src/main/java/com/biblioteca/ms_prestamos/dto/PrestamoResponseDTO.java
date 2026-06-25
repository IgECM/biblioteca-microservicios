package com.biblioteca.ms_prestamos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoResponseDTO {
    private Long id;
    private Long usuarioId;
    private Long libroId;
    private String fechaPrestamo;
}
