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
		String sql = "EXEC sp_bart_ventas_descuadre_caja_x_farmacia2 ?, ?";
		return jdbcLolfarTemplate.queryForList(sql, siscod, fecha);
	}
	
	public List<Map<String, Object>> obtenerProductosVentasDescuadre(Integer invnum) {
		String sql = "EXEC sp_bart_ventas_descuadre_caja_productos ?";
		return jdbcLolfarTemplate.queryForList(sql, invnum);
	}
	
	public List<Map<String, Object>> obtenerErroresVentasDescuadre(Integer invnum) {
		String sql = "EXEC sp_bart_ventas_errores_venta_detalle ?";
		return jdbcLolfarTemplate.queryForList(sql, invnum);
	}

    public List<Map<String, Object>> obtenerNotaCreditoPorId(Integer nconnum) {
        String sql = "EXEC sp_bart_ventas_comprobante_x_notas_credito_id ?";
        return jdbcLolfarTemplate.queryForList(sql, nconnum);
    }

    public List<Map<String, Object>> obtenerVentasPorMedioPago(LocalDate fecha, Integer sistema) {
        String sql = "EXEC sp_bart_ventas_ventasxmediospago ?, ?";
        return jdbcLolfarTemplate.queryForList(sql, fecha, sistema);
    }
}
