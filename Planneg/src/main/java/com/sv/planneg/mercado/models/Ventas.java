package com.sv.planneg.mercado.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
public class Ventas {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVentas;

    long previsto;

    long enero;

    long febrero;

    long marzo;

    long abril;

    long mayo;

    long junio;

    long julio;

    long agosto;

    long septiembre;

    long octubre;

    long noviembre;

    long diciembre;

    long total;

    int orden;

    @JoinColumn(name = "producto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto producto;
}
