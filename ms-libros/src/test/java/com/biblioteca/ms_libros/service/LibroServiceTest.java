package com.biblioteca.ms_libros.service;

import com.biblioteca.ms_libros.model.Libro;
import com.biblioteca.ms_libros.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibroServiceTest {

    @Mock
    private LibroRepository repository;

    @InjectMocks
    private LibroService service;

    @Test
    void obtenerLibroPorId() {

        Libro libro = new Libro(
                1L,
                "El MEJOR libro del mundo!!!",
                "Albert Epstein",
                67
        );

        when(repository.findById(1L))
                .thenReturn(Optional.of(libro));

        Libro resultado = service.obtenerLibroPorId(1L);

        assertNotNull(resultado);
        assertEquals("El MEJOR libro del mundo!!!", resultado.getTitulo());
    }

    @Test
    void guardarLibro() {

        Libro libro = new Libro(
                null,
                "El PEOR libro del mundo",
                "John Libro",
                21
        );

        when(repository.save(libro))
                .thenReturn(new Libro(
                        1L,
                        "El PEOR libro del mundo",
                        "John Libro",
                        21
                ));

        Libro resultado = service.guardarLibro(libro);

        assertNotNull(resultado);
        assertEquals("El PEOR libro del mundo", resultado.getTitulo());
    }

    @Test
    void eliminarLibro() {

        service.eliminarLibro(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
