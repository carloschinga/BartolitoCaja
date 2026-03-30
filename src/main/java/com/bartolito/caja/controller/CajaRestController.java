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

import com.bartolito.caja.service.CajaService;

@RestController
@RequestMapping("/api")
public class CajaRestController {

	@Autowired
	private CajaService cajaService;

	@GetMapping("/listarDescuadre")
	public ResponseEntity<Map<String, Object>> obtenerVentasDescuadreCajaXFarmacia(
			@RequestParam("siscod") Integer siscod,
			@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

		List<Map<String, Object>> ventas = cajaService.obtenerVentasDescuadreCajaXFarmacia(siscod, fecha);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("resultado", "ok");
		response.put("ventasDescuadre", ventas);

		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/listarProductosDescuadre")
	public ResponseEntity<Map<String, Object>> obtenerProductosVentasDescuadre(
			@RequestParam("invnum") Integer invnum) {

		List<Map<String, Object>> productos = cajaService.obtenerProductosVentasDescuadre(invnum);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("resultado", "ok");
		response.put("productos", productos);

		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/listarErroresDescuadre")
	public ResponseEntity<Map<String, Object>> obtenerErroresVentasDescuadre(
			@RequestParam("invnum") Integer invnum) {

		List<Map<String, Object>> errores = cajaService.obtenerErroresVentasDescuadre(invnum);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("resultado", "ok");
		response.put("errores", errores);

		return ResponseEntity.ok(response);
	}

}
