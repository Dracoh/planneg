package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.Promocion;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.repository.PromocionRepository;
import com.sv.planneg.mercado.services.IPromocionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PromocionServiceImpl implements IPromocionService {

    @Autowired
    PromocionRepository promocionRepository;

    @Autowired
    PlanRepository planRepository;

    @Override
    public List<Promocion> listar() {
        return promocionRepository.findAll();
    }

    @Override
    public List<Promocion> listarPorPlan(Plan plan) {
        return promocionRepository.findByPlan(plan);
    }

    @Override
    public boolean guardar(List<Promocion> promociones) {
        for(Promocion promocion : promociones) {
            Plan plan = planRepository.getOne(new Long(1));
            promocion.setPlan(plan);
            promocionRepository.save(promocion);
        }
        return true;
    }
}
