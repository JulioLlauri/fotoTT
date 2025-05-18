package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Contenido;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public ResponseEntity<List<Contenido>> listarTodos() {
        return ResponseEntity.ok(contenidoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> obtenerPorId(@PathVariable Integer id) {
        Optional<Contenido> contenido = contenidoService.findById(id);
        return contenido.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contenido> crear(@RequestBody Contenido contenido) {
    return ResponseEntity.ok(contenidoService.guardar(contenido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> actualizar(@PathVariable Integer id, @RequestBody Contenido contenido) {
        if (contenidoService.obtenerPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        Contenido actualizado = contenidoService.actualizar(id, contenido);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (contenidoService.obtenerPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contenidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
