package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.repository.ProductoRepository;
import com.sv.planneg.mercado.services.IProductoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> listarPorPlan(Plan plan) {
        return productoRepository.findByPlan(plan);
    }

    @Override
    public boolean guardar(List<Producto> productos) {
        for(Producto producto : productos) {
            Plan plan = planRepository.getOne(new Long(1));
            producto.setPlan(plan);
            productoRepository.save(producto);
        }
        return true;
    }
}
