package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.services.IPlanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PlanServiceImpl implements IPlanService {

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Plan> listar() {
        return planRepository.findAll();
    }

    @Override
    public Plan listarPorId(long idPlan) {
        return planRepository.getOne(idPlan);
    }

    @Override
    public boolean guardar(Plan plan) {
        planRepository.save(plan);
        return true;
    }
}
