package com.TimidosPeroTitulados.cl.TimidosPeroTitulados.controller;

import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.model.Reportes;
import com.TimidosPeroTitulados.cl.TimidosPeroTitulados.service.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping
    public ResponseEntity<List<Reportes>> listarTodos() {
        return ResponseEntity.ok(reportesService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reportes> obtenerPorId(@PathVariable Integer id) {
        Optional<Reportes> reporte = reportesService.obtenerPorId(id);
        return reporte.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reportes> crear(@RequestBody Reportes reportes) {
        Reportes nuevoReporte = reportesService.guardar(reportes);
        return ResponseEntity.ok(nuevoReporte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reportes> actualizar(@PathVariable Integer id, @RequestBody Reportes reportes) {
        if (reportesService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Reportes reporteActualizado = reportesService.actualizar(id, reportes);
        return ResponseEntity.ok(reporteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (reportesService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        reportesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}