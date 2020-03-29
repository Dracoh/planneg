package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.Segmento;
import com.sv.planneg.mercado.models.Ventas;

import java.util.List;

public interface IVentasService {

    List<Ventas> listar();

    List<Ventas> listarPorProducto(Producto producto);

    boolean guardar(Ventas ventas);
}
