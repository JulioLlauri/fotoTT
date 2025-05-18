package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Reporte;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.ReporteService;
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
@RequestMapping("/api/reporte")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> listarTodos() {
        List<Reporte> reportes = reporteService.obtenerTodos();
        return ResponseEntity.ok(reportes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerPorId(@PathVariable Integer id) {
        Optional<Reporte> reporte = reporteService.obtenerPorId(id);
        return reporte.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reporte> crear(@RequestBody Reporte reporte) {
        Reporte nuevoReporte = reporteService.guardar(reporte);
        return ResponseEntity.ok(nuevoReporte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizar(@PathVariable Integer id, @RequestBody Reporte reporte) {
        if (reporteService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Reporte reporteActualizado = reporteService.actualizar(id, reporte);
        return ResponseEntity.ok(reporteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (reporteService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        reporteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}