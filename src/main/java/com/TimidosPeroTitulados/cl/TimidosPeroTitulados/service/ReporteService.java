package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Reporte;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    
    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    
    public Optional<Reporte> obtenerPorId(Integer id) {
        return reporteRepository.findById(id);
    }

    
    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    
    public Reporte actualizar(Integer id, Reporte reporte) {
        reporte.setId_tipo_reporte(id); 
        return reporteRepository.save(reporte);
    }

    
    public void eliminar(Integer id) {
        reporteRepository.deleteById(id);
    }
}
