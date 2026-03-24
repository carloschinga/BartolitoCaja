package com.bartolito.caja.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bartolito.caja.repository.CajaRepository;

@Service
public class CajaService {

	@Autowired
	private CajaRepository cajaRepository;

	public List<Map<String, Object>> obtenerVentasDescuadreCajaXFarmacia(Integer siscod, LocalDate fecha) {
		return cajaRepository.obtenerVentasDescuadreCajaXFarmacia(siscod, fecha);
	}

	public List<Map<String, Object>> obtenerProductosVentasDescuadre(Integer invnum) {
		return cajaRepository.obtenerProductosVentasDescuadre(invnum);
	}
	
}
