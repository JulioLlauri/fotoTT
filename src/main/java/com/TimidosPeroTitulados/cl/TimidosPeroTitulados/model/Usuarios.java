package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 13, nullable = false)
    private String run; 

    @Column(nullable = false)
    private String nombres; 

    @Column(nullable = false)
    private String apellidos; 

    @Column(nullable = true)
    private Date fechaNacimiento; 

    @Column(nullable = false)
    private String correo; 

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Contenidos> contenidos;
}
