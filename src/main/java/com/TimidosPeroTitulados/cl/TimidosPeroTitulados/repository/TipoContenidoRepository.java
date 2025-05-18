package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.TipoContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContenidoRepository extends JpaRepository<TipoContenido, Integer> {
    
}
