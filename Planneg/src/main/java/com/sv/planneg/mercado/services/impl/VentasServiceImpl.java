package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.Ventas;
import com.sv.planneg.mercado.repository.VentasRepository;
import com.sv.planneg.mercado.services.IVentasService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class VentasServiceImpl implements IVentasService {

    @Autowired
    VentasRepository ventasRepository;

    @Override
    public List<Ventas> listar() {
        return ventasRepository.findAll();
    }

    @Override
    public List<Ventas> listarPorProducto(Producto producto) {
        return ventasRepository.findByProducto(producto);
    }

    @Override
    public boolean guardar(Ventas ventas) {
        ventasRepository.save(ventas);
        return true;
    }
}
