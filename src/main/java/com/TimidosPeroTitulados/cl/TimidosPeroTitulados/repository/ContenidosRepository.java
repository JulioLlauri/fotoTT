package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Contenidos;

@Repository
public interface ContenidosRepository extends JpaRepository<Contenidos,Integer>{

    
}