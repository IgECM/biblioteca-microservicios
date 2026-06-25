package com.biblioteca.ms_notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionRequestDTO {
    private String destinatario;
    private String mensaje;
}