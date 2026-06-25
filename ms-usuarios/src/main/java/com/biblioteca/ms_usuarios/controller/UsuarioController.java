package com.biblioteca.ms_usuarios.controller;

import com.biblioteca.ms_usuarios.dto.UsuarioRequestDTO;
import com.biblioteca.ms_usuarios.dto.UsuarioResponseDTO;
import com.biblioteca.ms_usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioResponseDTO> listarUsuarios() {
        return service.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO obtenerUsuario(@PathVariable Long id) {
        return service.obtenerUsuarioPorId(id);
    }

    @PostMapping
    public UsuarioResponseDTO guardarUsuario(@RequestBody UsuarioRequestDTO dto) {
        return service.guardarUsuario(dto);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO actualizarUsuario(@PathVariable Long id,
                                                @RequestBody UsuarioRequestDTO dto) {
        return service.actualizarUsuario(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }
}
