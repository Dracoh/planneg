package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.ProductoSegmento;
import com.sv.planneg.mercado.models.Segmento;

import java.util.List;

public interface IProductoSegmentoService {

    List<ProductoSegmento> listar();

    List<ProductoSegmento> listarPorProducto(Producto producto);

    List<ProductoSegmento> listarPorSegmento(Segmento segmento);

    List<ProductoSegmento> listarPorPlan(Plan plan);

    boolean guardar(ProductoSegmento productoSegmento);

    void generar();
}
