package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.TipoUsuario;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipousuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarTodos() {
        List<TipoUsuario> tipos = tipoUsuarioService.obtenerTodos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> obtenerPorId(@PathVariable Integer id) {
        Optional<TipoUsuario> tipo = tipoUsuarioService.obtenerPorId(id);
        return tipo.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> crear(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario nuevo = tipoUsuarioService.guardar(tipoUsuario);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizar(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario) {
        if (tipoUsuarioService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        TipoUsuario actualizado = tipoUsuarioService.actualizar(id, tipoUsuario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (tipoUsuarioService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoUsuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}