package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Contenidos;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.ContenidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidosController {

    @Autowired
    private ContenidosService contenidosService;

    @GetMapping
    public ResponseEntity<List<Contenidos>> listarTodos() {
        return ResponseEntity.ok(contenidosService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenidos> obtenerPorId(@PathVariable Integer id) {
        Contenidos contenido = contenidosService.obtenerPorId(id);
        if (contenido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contenido);
    }

    @PostMapping
    public ResponseEntity<Contenidos> crear(@RequestBody Contenidos contenidos) {
        return ResponseEntity.ok(contenidosService.guardar(contenidos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenidos> actualizar(@PathVariable Integer id, @RequestBody Contenidos contenidos) {
        if (contenidosService.obtenerPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        Contenidos actualizado = contenidosService.actualizar(id, contenidos);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (contenidosService.obtenerPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contenidosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}