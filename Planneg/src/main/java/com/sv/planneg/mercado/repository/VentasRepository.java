package com.sv.planneg.mercado.repository;

import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
    List<Ventas> findByProducto(Producto producto);
}
