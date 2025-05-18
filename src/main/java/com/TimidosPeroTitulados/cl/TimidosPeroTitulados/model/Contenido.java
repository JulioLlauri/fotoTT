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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido")
    private Integer id_contenido;

    @Column(name = "vistas_contenido")
    private Integer vistas_contenido;

    @Column(name = "editado")
    private String editado;

    @Column(name = "fecha_edicion_contenido")
    private Date fecha_edicion_contenido;

    @Column(name = "contenido_reportado")
    private String contenido_reportado;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "detalle_contenido")
    private String detalle_contenido;

    @Column(name = "fecha_publicacion")
    private Integer fecha_publicacion;

    @Column(name = "reportado")
    private String reportado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contenido")
    private TipoContenido tipoContenido;

    @ManyToOne
    @JoinColumn(name = "id_contenidos")
    @JsonBackReference 
    private Contenidos contenidos;


}
// haha 
