package com.sv.planneg.mercado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "plan")
@Getter
@Setter
@NoArgsConstructor
public class Plan {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;

    String nombre;

    String descripcion;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    private List<Competencia> competenciaList;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    private List<Producto> productoList;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    private List<Segmento> segmentoList;

    @OneToMany(mappedBy = "plan")
    @JsonIgnore
    private List<Promocion> promocionList;

    @Override
    public String toString() {
        return "plan=" + idPlan + " ]";
    }
}
