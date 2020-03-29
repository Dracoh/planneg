package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Competencia;
import com.sv.planneg.mercado.models.Plan;

import java.util.List;

public interface IPlanService {

    List<Plan> listar();

    Plan listarPorId(long idPlan);

    boolean guardar(Plan plan);
}
