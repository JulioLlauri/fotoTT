package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Usuarios;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    
    public Usuarios saveOrUpdate(Usuarios usuario) {
        return usuariosRepository.save(usuario); 
    }

    
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    
    public Optional<Usuarios> findById(long id) {
        return usuariosRepository.findById(id);
    }

    
    public void deleteById(long id) {
        usuariosRepository.deleteById(id);
    }
}
