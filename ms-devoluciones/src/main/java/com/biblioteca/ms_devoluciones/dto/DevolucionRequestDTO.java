package com.biblioteca.ms_devoluciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevolucionRequestDTO {
    private Long prestamoId;
    private String fechaDevolucion;
}