package com.sv.planneg.mercado.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "competencia")
@Getter
@Setter
@NoArgsConstructor
public class Competencia {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetencia;

    String nombreProducto;

    long precio;

    String unidad;

    String calidad;

    String clienteObjeto;

    String mercadoObjetivo;

    int cuota;

    @JoinColumn(name = "plan", referencedColumnName = "idPlan")
    @ManyToOne
    private Plan plan;

    @Override
    public String toString() {
        return "competencia=" + idCompetencia + " ]";
    }
}
