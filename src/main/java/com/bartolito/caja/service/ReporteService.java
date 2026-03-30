package com.bartolito.caja.service;

import com.bartolito.caja.repository.NotaCreditoRepository;
import com.bartolito.caja.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;
    public List<Map<String, Object>> obtenerNotasCredito(Integer siscod, String fecha) {
        return reporteRepository.obtenerNotasCredito(siscod, fecha);
    }

    public List<Map<String, Object>> obtenerFacturasPorFormaPago(Integer siscod, String fecha) {
        return reporteRepository.obtenerFacturasPorFormaPago(siscod, fecha);
    }
}
