package com.sv.planneg.mercado.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "producto_segmento")
@Getter
@Setter
@NoArgsConstructor
public class ProductoSegmento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductoSegmento;

    String presentacion;

    /**plaza*/
    String demanda;

    long participacion;

    int distancia;

    long costotransporte;

    String lugar;

    @JoinColumn(name = "segmento", referencedColumnName = "idSegmento")
    @ManyToOne
    private Segmento segmento;

    @JoinColumn(name = "producto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto producto;

}
