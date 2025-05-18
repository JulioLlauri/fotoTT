package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    
}
