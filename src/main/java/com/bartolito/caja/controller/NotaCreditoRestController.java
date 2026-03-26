package com.bartolito.caja.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bartolito.caja.service.NotaCreditoService;

@RestController
@RequestMapping("/api")
public class NotaCreditoRestController {

	@Autowired
	private NotaCreditoService notaCreditoService;

	@GetMapping("/listarNotasCreditoDescuadre")
	public ResponseEntity<Map<String, Object>> obtenerNotasCreditoDescuadre(@RequestParam("siscod") Integer siscod,
			@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

		List<Map<String, Object>> notas = notaCreditoService.obtenerNotasCreditoDescuadre(siscod, fecha);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("resultado", "ok");
		response.put("notasDescuadre", notas);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/listarProductosNotasCreditoDescuadre")
	public ResponseEntity<Map<String, Object>> obtenerProductosNotaCreditoDescuadre(
			@RequestParam("nconum") Integer nconum) {

		List<Map<String, Object>> productos = notaCreditoService.obtenerProductosNotaCreditoDescuadre(nconum);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("resultado", "ok");
		response.put("productos", productos);

		return ResponseEntity.ok(response);
	}

}
