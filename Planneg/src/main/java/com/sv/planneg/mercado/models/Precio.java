package com.sv.planneg.mercado.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "precio")
@Getter
@Setter
@NoArgsConstructor
public class Precio {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrecio;

    int orden;

    long menor;

    long mayor;

    @JoinColumn(name = "producto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto producto;
}
