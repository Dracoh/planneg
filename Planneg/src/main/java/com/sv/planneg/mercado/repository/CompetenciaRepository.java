package com.sv.planneg.mercado.repository;

import com.sv.planneg.mercado.models.Competencia;
import com.sv.planneg.mercado.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    List<Competencia> findByPlan(Plan plan);
}
