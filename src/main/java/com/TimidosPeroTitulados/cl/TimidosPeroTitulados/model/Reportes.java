package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reportes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reportes;


    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reporte")
    private Reporte tipoReporte;
}