package com.sv.planneg.mercado.repository;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Long> {
    List<Promocion> findByPlan(Plan plan);
}
