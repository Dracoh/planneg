package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.dto.SegmentoDto;
import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Precio;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.Segmento;

import java.util.List;

public interface ISegmentoService {

    List<Segmento> listar();

    List<Segmento> listarPorPlan(Plan plan);

    boolean guardar(List<Segmento> segmento);

    SegmentoDto guardadoInicial(int cantidad);
}
