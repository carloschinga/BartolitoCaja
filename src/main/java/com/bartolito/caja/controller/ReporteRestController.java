package com.bartolito.caja.controller;

import com.bartolito.caja.service.NotaCreditoService;
import com.bartolito.caja.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReporteRestController {

	@Autowired
	private ReporteService reporteService;

    @GetMapping("/listarNotasCredito")
    public ResponseEntity<Map<String, Object>> obtenerNotasCredito(
            @RequestParam(value = "siscod", required = false) Integer siscod,
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        List<Map<String, Object>> notas = reporteService.obtenerNotasCredito(
                siscod,
                fecha.toString()   // conviertes a String para tu repository
        );

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("resultado", "ok");
        response.put("notasCredito", notas);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/listarFacturasFormaPago")
    public ResponseEntity<Map<String, Object>> obtenerFacturasPorFormaPago(
            @RequestParam(value = "siscod", required = false) Integer siscod,
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        List<Map<String, Object>> facturas = reporteService.obtenerFacturasPorFormaPago(
                siscod,
                fecha.toString()   // conviertes a String
        );

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("resultado", "ok");
        response.put("facturas", facturas);

        return ResponseEntity.ok(response);
    }

}
