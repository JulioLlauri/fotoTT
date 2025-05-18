package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.TipoContenido;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.TipoContenidoService;
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
@RequestMapping("/api/tipo-contenido")
public class TipoContenidoController {

    @Autowired
    private TipoContenidoService tipoContenidoService;

    
    @GetMapping
    public ResponseEntity<List<TipoContenido>> listarTodos() {
        List<TipoContenido> tiposContenido = tipoContenidoService.obtenerTodos();
        return ResponseEntity.ok(tiposContenido);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TipoContenido> obtenerPorId(@PathVariable Integer id) {
        Optional<TipoContenido> tipoContenido = tipoContenidoService.obtenerPorId(id);
        return tipoContenido.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<TipoContenido> crear(@RequestBody TipoContenido tipoContenido) {
        TipoContenido nuevoTipoContenido = tipoContenidoService.guardar(tipoContenido);
        return ResponseEntity.ok(nuevoTipoContenido);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<TipoContenido> actualizar(@PathVariable Integer id, @RequestBody TipoContenido tipoContenido) {
        if (tipoContenidoService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        TipoContenido tipoContenidoActualizado = tipoContenidoService.actualizar(id, tipoContenido);
        return ResponseEntity.ok(tipoContenidoActualizado);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (tipoContenidoService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoContenidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
