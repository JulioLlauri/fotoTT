package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.repository;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    
}
