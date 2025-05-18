package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Reportes;

@Repository
public interface ReportesRepository extends JpaRepository<Reportes, Integer>{

    
}