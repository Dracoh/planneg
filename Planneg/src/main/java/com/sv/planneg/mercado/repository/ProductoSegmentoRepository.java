package com.sv.planneg.mercado.repository;

import com.sv.planneg.mercado.models.Producto;
import com.sv.planneg.mercado.models.ProductoSegmento;
import com.sv.planneg.mercado.models.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoSegmentoRepository extends JpaRepository<ProductoSegmento, Long> {
    List<ProductoSegmento> findByProducto(Producto producto);

    List<ProductoSegmento> findBySegmento(Segmento segmento);
}
