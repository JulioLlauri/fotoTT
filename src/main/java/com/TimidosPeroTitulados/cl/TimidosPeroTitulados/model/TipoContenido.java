package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity  
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoContenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_contenido;

    @Column(name = "nombre_tipo_contenido")
    private String nombre_tipo_contenido;

    @Column(name = "descripcion_tipo_contenido")
    private String descripcion_tipo_contenido;


    public void setId_tipo_contenido(Integer id) {
        this.id_tipo_contenido = id;
    }


}
