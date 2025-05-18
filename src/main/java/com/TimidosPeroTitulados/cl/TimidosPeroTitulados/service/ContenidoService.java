package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Contenido;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public Optional<Contenido> findById(Integer id) {
        return contenidoRepository.findById(id);
    }

    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }

    public Contenido obtenerPorId(Integer id) {
        return contenidoRepository.findById(id).orElse( null);
    }

    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public Contenido actualizar(Integer id, Contenido contenido) {
        contenido.setId_contenido(id); // OBLIGATORIO establecer el ID correcto
        return contenidoRepository.save(contenido);
    }

    public void eliminar(Integer id) {
        contenidoRepository.deleteById(id);
    }
}
