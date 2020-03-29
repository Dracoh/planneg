package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.ProductoSegmento;
import com.sv.planneg.mercado.models.Segmento;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.repository.ProductoRepository;
import com.sv.planneg.mercado.repository.ProductoSegmentoRepository;
import com.sv.planneg.mercado.repository.SegmentoRepository;
import com.sv.planneg.mercado.services.IProductoSegmentoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProductoSegmentoServiceImpl implements IProductoSegmentoService {

    @Autowired
    ProductoSegmentoRepository productoSegmentoRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    SegmentoRepository segmentoRepository;

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<ProductoSegmento> listar() {
        return productoSegmentoRepository.findAll();
    }

    @Override
    public List<ProductoSegmento> listarPorProducto(Producto producto) {
        return productoSegmentoRepository.findByProducto(producto);
    }

    @Override
    public List<ProductoSegmento> listarPorSegmento(Segmento segmento) {
        return productoSegmentoRepository.findBySegmento(segmento);
    }

    @Override
    public List<ProductoSegmento> listarPorPlan(Plan plan) {
        List<Producto> productos = productoRepository.findByPlan(plan);
        List<ProductoSegmento> listado = productoSegmentoRepository.findAll();
        listado.clear();

        for(Producto producto : productos){
            listado.addAll(productoSegmentoRepository.findByProducto(producto));
        }
        return listado;
    }

    @Override
    public boolean guardar(ProductoSegmento productoSegmento) {
        productoSegmentoRepository.save(productoSegmento);
        return true;
    }

    @Override
    public void generar() {
        Plan plan = planRepository.getOne(new Long(1));
        List<Producto> productos = productoRepository.findByPlan(plan);
        List<Segmento> segmentos = segmentoRepository.findByPlan(plan);

        for(Producto producto : productos){
            for(Segmento segmento : segmentos) {
                ProductoSegmento productoSegmento = new ProductoSegmento();
                productoSegmento.setProducto(producto);
                productoSegmento.setSegmento(segmento);
                productoSegmentoRepository.save(productoSegmento);
            }
        }
    }

}
