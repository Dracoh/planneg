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
@Table(name = "segmento")
@Getter
@Setter
@NoArgsConstructor
public class Segmento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSegmento;

    String nombre;

    int orden;

    @JoinColumn(name = "plan", referencedColumnName = "idPlan")
    @ManyToOne
    private Plan plan;

    @OneToMany(mappedBy = "segmento")
    @JsonIgnore
    private List<ProductoSegmento> productoSegmentoList;

    @Override
    public String toString() {
        return "segmento=" + idSegmento + " ]";
    }
}
