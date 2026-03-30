package com.bartolito.caja.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReporteRepository {
    @Autowired
    @Qualifier("lolfarJdbcTemplate")
    private JdbcTemplate jdbcLolfarTemplate;

    public List<Map<String, Object>> obtenerNotasCredito(Integer siscod, String fecha) {
        String sql = "EXEC sp_bart_ventas_notas_credito ?, ?";

        return jdbcLolfarTemplate.queryForList(
                sql,
                fecha,     // @fecha
                siscod     // @siscod (puede ser null)
        );
    }
    public List<Map<String, Object>> obtenerFacturasPorFormaPago(Integer siscod, String fecha) {
        String sql = "EXEC sp_bart_ventas_facturas_forma_pago ?, ?";

        return jdbcLolfarTemplate.queryForList(
                sql,
                fecha,     // @fecha
                siscod     // @siscod (puede ser null)
        );
    }

}
