package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Usuarios;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    
    @PostMapping
    public ResponseEntity<Usuarios> crearOActualizar(@RequestBody Usuarios usuario) {
        Usuarios usuarioGuardado = usuariosService.saveOrUpdate(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado); 
    }

    
    @GetMapping
    public ResponseEntity<List<Usuarios>> listar() {
        List<Usuarios> usuarios = usuariosService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(usuarios); 
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable long id) {
        Optional<Usuarios> usuarioOptional = usuariosService.findById(id);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok(usuarioOptional.get()); 
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        Optional<Usuarios> usuarioOptional = usuariosService.findById(id);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); 
        }
        usuariosService.deleteById(id);
        return ResponseEntity.noContent().build(); 
    }
}
