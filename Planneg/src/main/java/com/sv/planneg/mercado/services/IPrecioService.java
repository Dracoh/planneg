package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Competencia;
import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Precio;
import com.sv.planneg.mercado.models.Producto;

import java.util.List;

public interface IPrecioService {

    List<Precio> listar();

    List<Precio> listarPorProducto(Producto producto);

    List<Precio> listarPorPlan(Plan plan);

    boolean guardar(List<Precio> precio);
}
