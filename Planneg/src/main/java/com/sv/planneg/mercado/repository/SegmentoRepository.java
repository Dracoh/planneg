package com.sv.planneg.mercado.repository;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SegmentoRepository extends JpaRepository<Segmento, Long> {
    List<Segmento> findByPlan(Plan plan);
}
