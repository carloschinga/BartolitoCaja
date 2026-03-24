package com.bartolito.caja.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CajaRepository {

	@Autowired
	@Qualifier("lolfarJdbcTemplate")
	private JdbcTemplate jdbcLolfarTemplate;

	public List<Map<String, Object>> obtenerVentasDescuadreCajaXFarmacia(Integer siscod, LocalDate fecha) {
		String sql = "EXEC sp_bart_ventas_descuadre_caja_x_farmacia ?, ?";
		return jdbcLolfarTemplate.queryForList(sql, siscod, fecha);
	}
}
