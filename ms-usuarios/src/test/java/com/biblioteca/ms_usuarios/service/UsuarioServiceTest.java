package com.biblioteca.ms_usuarios.service;

import com.biblioteca.ms_usuarios.model.Usuario;
import com.biblioteca.ms_usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void obtenerUsuarioPorId() {

        Usuario usuario = new Usuario(1L, "Juan", "juan@correo.cl");

        when(repository.findById(1L))
                .thenReturn(Optional.of(usuario));

        Usuario resultado = service.obtenerUsuarioPorId(1L);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void guardarUsuario() {

        Usuario usuario = new Usuario(null, "Pedro", "pedro@correo.cl");

        when(repository.save(usuario))
                .thenReturn(new Usuario(1L, "Pedro", "pedro@correo.cl"));

        Usuario resultado = service.guardarUsuario(usuario);

        assertNotNull(resultado);
        assertEquals("Pedro", resultado.getNombre());
    }

    @Test
    void eliminarUsuario() {

        service.eliminarUsuario(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
