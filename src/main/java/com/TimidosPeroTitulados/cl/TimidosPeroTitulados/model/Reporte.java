package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_reporte")
    private Integer id_tipo_reporte;

    @Column(name = "reportes_id_reportes")
    private Integer reportes_id_reportes;

    @Column(name = "tipo_reporte")
    private String tipo_reporte;

    @Column(name = "usuario_reporte_id")
    private Integer usuario_reporte_id;

    @Column(name = "usuario_reportado_id")
    private Integer usuario_reportado_id;

    @Column(name = "descripcion_reporte")
    private String descripcion_reporte;

    @Column(name = "fecha_reporte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_reporte;

    @Column(name = "estado_reporte")
    private String estado_reporte;

    @Column(name = "id_contenido")
    private Integer id_contenido;


}
