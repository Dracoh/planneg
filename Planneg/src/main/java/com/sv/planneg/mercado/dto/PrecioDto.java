package com.sv.planneg.mercado.dto;

import com.sv.planneg.mercado.models.Precio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrecioDto {

    List<Precio> precios;
}
