package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Competencia;
import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.repository.CompetenciaRepository;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.services.ICompetenciaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CompetenciaServiceImpl implements ICompetenciaService {

    @Autowired
    CompetenciaRepository competenciaRepository;

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Competencia> listar() {
        return competenciaRepository.findAll();
    }

    @Override
    public List<Competencia> listarPorPlan(Plan plan) {
        return competenciaRepository.findByPlan(plan);
    }

    @Override
    public boolean guardar(List<Competencia> competencias) {
        for(Competencia competencia : competencias) {
            Plan plan = planRepository.getOne(new Long(1));
            competencia.setPlan(plan);
            competenciaRepository.save(competencia);
        }
        return true;
    }
}
