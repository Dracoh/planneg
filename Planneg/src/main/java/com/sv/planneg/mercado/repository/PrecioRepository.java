package com.sv.planneg.mercado.repository;

import com.sv.planneg.mercado.models.Precio;
import com.sv.planneg.mercado.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {
    List<Precio> findAllByProducto(Producto producto);
}
