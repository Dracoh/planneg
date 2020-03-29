package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Precio;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.repository.PrecioRepository;
import com.sv.planneg.mercado.repository.ProductoRepository;
import com.sv.planneg.mercado.services.IPrecioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class PrecioServiceImpl implements IPrecioService {

    @Autowired
    PrecioRepository precioRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Precio> listar() {
        return precioRepository.findAll();
    }

    @Override
    public List<Precio> listarPorProducto(Producto producto) {
        return precioRepository.findAllByProducto(producto);
    }

    @Override
    public List<Precio> listarPorPlan(Plan plan) {
        List<Precio> precios = new ArrayList<>();
        for(Producto producto : productoRepository.findByPlan(plan)){
            precios.add(precioRepository.findAllByProducto(producto).get(0));
        }
        return precios;
    }

    @Override
    public boolean guardar(List<Precio> precios) {

        for(Precio precio : precios){
            precio.setProducto(productoRepository.getOne(precio.getProducto().getIdProducto()));
            precioRepository.save(precio);
        }
        return true;
    }
}
