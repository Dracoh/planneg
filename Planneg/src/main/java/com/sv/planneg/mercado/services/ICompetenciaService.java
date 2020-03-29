package com.sv.planneg.mercado.services;

import com.sv.planneg.mercado.models.Competencia;
import com.sv.planneg.mercado.models.Plan;

import java.util.List;

public interface ICompetenciaService {

    List<Competencia> listar();

    List<Competencia> listarPorPlan(Plan plan);

    boolean guardar(List<Competencia> competencias);
}
