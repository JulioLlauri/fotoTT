package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.TipoContenido;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.TipoContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContenidoService {

    @Autowired
    private TipoContenidoRepository tipoContenidoRepository;

    
    public List<TipoContenido> obtenerTodos() {
        return tipoContenidoRepository.findAll();
    }

    
    public Optional<TipoContenido> obtenerPorId(Integer id) {
        return tipoContenidoRepository.findById(id);
    }

    
    public TipoContenido guardar(TipoContenido tipoContenido) {
        return tipoContenidoRepository.save(tipoContenido);
    }

    
    public TipoContenido actualizar(Integer id, TipoContenido tipoContenido) {
        tipoContenido.setId_tipo_contenido(id);  
        return tipoContenidoRepository.save(tipoContenido);
    }

    
    public void eliminar(Integer id) {
        tipoContenidoRepository.deleteById(id);
    }
}
