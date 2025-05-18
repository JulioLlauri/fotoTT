package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Reportes;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportesService {

    @Autowired
    private ReportesRepository reportesRepository;

    public List<Reportes> obtenerTodos() {
        return reportesRepository.findAll();
    }

    public Optional<Reportes> obtenerPorId(Integer id) {
        return reportesRepository.findById(id);
    }

    public Reportes guardar(Reportes reportes) {
        return reportesRepository.save(reportes);
    }

    public Reportes actualizar(Integer id, Reportes reportes) {
        reportes.setId_reportes(id);
        return reportesRepository.save(reportes);
    }

    public void eliminar(Integer id) {
        reportesRepository.deleteById(id);
    }
}