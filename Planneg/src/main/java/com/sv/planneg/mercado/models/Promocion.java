package com.sv.planneg.mercado.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "promocion")
@Getter
@Setter
@NoArgsConstructor
public class Promocion {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;

    String nombre;

    String tipo;

    String caracteristica;

    Date inicio;

    Date fin;

    long costoAnual;

    int orden;

    @JoinColumn(name = "plan", referencedColumnName = "idPlan")
    @ManyToOne
    private Plan plan;
}
