package com.biblioteca.ms_prestamos.service;

import com.biblioteca.ms_prestamos.client.UsuarioClient;
import com.biblioteca.ms_prestamos.dto.UsuarioDTO;
import com.biblioteca.ms_prestamos.model.Prestamo;
import com.biblioteca.ms_prestamos.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    // se asegura que el usuario exista antes de guardar el prestamo
    private PrestamoRepository repository;
    private UsuarioClient usuarioClient;
    public PrestamoService(
            PrestamoRepository repository,
            UsuarioClient usuarioClient
    ) {

        this.repository = repository;
        this.usuarioClient = usuarioClient;

    }
    // obtiene todos los prestamos, los de abajo son para obtener por id, guardar, actualizar y eliminar prestamos
    public List<Prestamo> obtenerPrestamos(){

        return repository.findAll();

    }

    public Prestamo obtenerPrestamoPorId(Long id){

        return repository.findById(id).orElse(null);

    }

    public Prestamo guardarPrestamo(Prestamo prestamo){
        // revisa si el usuario existe antes de guardar
        UsuarioDTO usuario =
                usuarioClient.obtenerUsuario(
                        prestamo.getUsuarioId()
                );
        
        if(usuario == null){
            return null;
        }
        return repository.save(prestamo);

    }

    public Prestamo actualizarPrestamo(
            Long id,
            Prestamo prestamo
    ){

        Prestamo existente =
                repository.findById(id).orElse(null);

        if(existente != null){

            existente.setUsuarioId(
                    prestamo.getUsuarioId()
            );

            existente.setLibroId(
                    prestamo.getLibroId()
            );

            existente.setFechaPrestamo(
                    prestamo.getFechaPrestamo()
            );

            return repository.save(existente);

        }

        return null;
    }

    public void eliminarPrestamo(Long id){
        repository.deleteById(id);
    }

}