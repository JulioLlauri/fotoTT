package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.TipoUsuario;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuario> obtenerTodos() {
        return tipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuario> obtenerPorId(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuario guardar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public TipoUsuario actualizar(Integer id, TipoUsuario tipoUsuario) {
        tipoUsuario.setId(id);
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void eliminar(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}