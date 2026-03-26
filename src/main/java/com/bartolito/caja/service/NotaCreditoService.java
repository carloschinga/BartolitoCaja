package com.bartolito.caja.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bartolito.caja.repository.NotaCreditoRepository;

@Service
public class NotaCreditoService {

	@Autowired
	private NotaCreditoRepository notaCreditoRepository;

	public List<Map<String, Object>> obtenerNotasCreditoDescuadre(Integer siscod, LocalDate fecha) {
		return notaCreditoRepository.obtenerNotasCreditoDescuadre(siscod, fecha);
	}

	public List<Map<String, Object>> obtenerProductosNotaCreditoDescuadre(Integer nconum) {
		return notaCreditoRepository.obtenerProductosNotaCreditoDescuadre(nconum);
	}

}