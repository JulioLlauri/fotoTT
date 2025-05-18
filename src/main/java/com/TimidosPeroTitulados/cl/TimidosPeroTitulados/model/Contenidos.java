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

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "Contenidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contenidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_contenidos;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuarios usuario;


}