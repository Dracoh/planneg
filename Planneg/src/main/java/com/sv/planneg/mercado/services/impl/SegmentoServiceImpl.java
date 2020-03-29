package com.sv.planneg.mercado.services.impl;

import com.sv.planneg.mercado.dto.SegmentoDto;
import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Segmento;
import com.sv.planneg.mercado.repository.PlanRepository;
import com.sv.planneg.mercado.repository.SegmentoRepository;
import com.sv.planneg.mercado.services.ISegmentoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class SegmentoServiceImpl implements ISegmentoService {

    @Autowired
    SegmentoRepository segmentoRepository;

    @Autowired
    PlanRepository planRepository;


    @Override
    public List<Segmento> listar() {
        return segmentoRepository.findAll();
    }

    @Override
    public List<Segmento> listarPorPlan(Plan plan) {
        return segmentoRepository.findByPlan(plan);
    }

    @Override
    public boolean guardar(List<Segmento> segmentos) {
        for(Segmento segmento : segmentos) {
            segmento.setPlan(planRepository.getOne(new Long(1)));
            segmentoRepository.save(segmento);
        }
        return true;
    }

    @Override
    public SegmentoDto guardadoInicial(int cantidad){
        SegmentoDto segmentoDto = new SegmentoDto();
        segmentoDto.setSegmentos(new ArrayList<>());
        for(int i=0; i<cantidad; i++){
            Segmento segmento = new Segmento();
            segmento.setPlan(planRepository.getOne(new Long(1)));
            segmentoDto.getSegmentos().add(segmentoRepository.save(segmento));
        }
        return segmentoDto;
    }

}
