package com.biblioteca.ms_usuarios.service;

import com.biblioteca.ms_usuarios.dto.UsuarioRequestDTO;
import com.biblioteca.ms_usuarios.dto.UsuarioResponseDTO;
import com.biblioteca.ms_usuarios.model.Usuario;
import com.biblioteca.ms_usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponseDTO> obtenerUsuarios() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = repository.findById(id).orElse(null);
        return usuario != null ? toResponseDTO(usuario) : null;
    }

    public UsuarioResponseDTO guardarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        return toResponseDTO(repository.save(usuario));
    }

    public UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = repository.findById(id).orElse(null);

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(dto.getNombre());
            usuarioExistente.setCorreo(dto.getCorreo());
            return toResponseDTO(repository.save(usuarioExistente));
        }

        return null;
    }

    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getCorreo());
    }
}