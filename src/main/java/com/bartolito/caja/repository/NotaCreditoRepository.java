package com.bartolito.caja.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NotaCreditoRepository {

	@Autowired
	@Qualifier("lolfarJdbcTemplate")
	private JdbcTemplate jdbcLolfarTemplate;

	public List<Map<String, Object>> obtenerNotasCreditoDescuadre(Integer siscod, LocalDate fecha) {
		String sql = "EXEC sp_bart_ventas_notas_credito productos ?, ?";
		return jdbcLolfarTemplate.queryForList(sql, siscod, fecha);
	}
	
	public List<Map<String, Object>> obtenerProductosNotaCreditoDescuadre(Integer nconum) {
		String sql = "EXEC sp_bart_ventas_notas_credito productos ?";
		return jdbcLolfarTemplate.queryForList(sql, nconum);
	}
}
