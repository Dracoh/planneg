package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Precio;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.Promocion;

import java.util.List;

public interface IPromocionService {

    List<Promocion> listar();

    List<Promocion> listarPorPlan(Plan plan);

    boolean guardar(List<Promocion> promocion);
}
