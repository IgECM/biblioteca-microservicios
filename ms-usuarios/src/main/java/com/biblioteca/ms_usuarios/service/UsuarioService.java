package com.biblioteca.ms_usuarios.service;

import com.biblioteca.ms_usuarios.model.Usuario;
import com.biblioteca.ms_usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> obtenerUsuarios() {
        return repository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {

        Usuario usuarioExistente = repository.findById(id).orElse(null);

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCorreo(usuario.getCorreo());

            return repository.save(usuarioExistente);
        }

        return null;
    }

    public void eliminarUsuario(Long id) {
        repository.deleteById(id);
    }
}