package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Contenidos;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.ContenidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ContenidosService {

    @Autowired
    private ContenidosRepository contenidosRepository;

    public List<Contenidos> obtenerTodos() {
        return contenidosRepository.findAll();
    }

    public Contenidos obtenerPorId(Integer id) {
        return contenidosRepository.findById(id).orElse(null);
    }

    public Contenidos guardar(Contenidos contenidos) {
        return contenidosRepository.save(contenidos);
    }

    public Contenidos actualizar(Integer id, Contenidos contenidos) {
        contenidos.setId_contenidos(id);
        return contenidosRepository.save(contenidos);
    }

    public void eliminar(Integer id) {
        contenidosRepository.deleteById(id);
    }
}