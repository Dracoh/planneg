package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Precio;
import com.sv.planneg.mercado.models.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> listar();

    List<Producto> listarPorPlan(Plan plan);

    boolean guardar(List<Producto> producto);
}
