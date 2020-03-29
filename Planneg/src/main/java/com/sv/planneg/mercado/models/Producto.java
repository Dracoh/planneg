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
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    String nombre;

    String presentacion;

    String caracteristica;

    String imagen;

    int orden;

    @JoinColumn(name = "plan", referencedColumnName = "idPlan")
    @ManyToOne
    private Plan plan;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<ProductoSegmento> productoSegmentoList;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<Ventas> ventasList;

    @Override
    public String toString() {
        return "producto=" + idProducto + " ]";
    }
}
