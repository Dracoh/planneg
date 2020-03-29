package com.sv.planneg.mercado.controller;

import java.util.ArrayList;
import java.util.Map;

import com.sv.planneg.mercado.dto.CompetenciaDto;
import com.sv.planneg.mercado.dto.PrecioDto;
import com.sv.planneg.mercado.dto.PromocionDto;
import com.sv.planneg.mercado.models.Competencia;
import com.sv.planneg.mercado.models.Plan;
import com.sv.planneg.mercado.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sv.planneg.mercado.dto.ProductoDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@Getter
@Setter
public class MercadoController {

	@Autowired
	ICompetenciaService competenciaService;

	@Autowired
	IPlanService planService;

	@Autowired
    IProductoService productoService;

	@Autowired
    IPromocionService promocionService;

	@Autowired
    IPrecioService precioService;

	@RequestMapping("competencia")
	public String competencia(Map<String, Object> model) {
		System.out.println("competencia");
        Plan plan = planService.listarPorId(1);
        CompetenciaDto competenciaDto = new CompetenciaDto();
        competenciaDto.setCompetencias(competenciaService.listarPorPlan(plan));
        model.put("competenciaDto", competenciaDto);
		model.put("competencias", competenciaService.listarPorPlan(plan));
		return "competencia";
	}

    @RequestMapping("guardarCompetencia")
    public String guardarCompetencia(Map<String, Object> model, @ModelAttribute CompetenciaDto competenciaDto) {
        log.info("guardando..."+competenciaDto.getCompetencias());
	    competenciaService.guardar(competenciaDto.getCompetencias());
        Plan plan = planService.listarPorId(1);

        model.put("competenciaDto", competenciaDto);
        model.put("competencias", competenciaService.listarPorPlan(plan));
	    return "competencia";
    }

    @RequestMapping("agregarCompetencia")
    public String agregarCompetencia(Map<String, Object> model, @ModelAttribute CompetenciaDto competenciaDto) {
        log.info("agregando...");
        //competenciaDto.setCompetencias(new ArrayList<>());
        Competencia competencia = new Competencia();
        Plan plan = planService.listarPorId(1);
        competencia.setPlan(plan);
        if(competenciaDto.getCompetencias()==null) {
            competenciaDto.setCompetencias(new ArrayList<>());
        }
        competenciaDto.getCompetencias().add(competencia);
        competenciaService.guardar(competenciaDto.getCompetencias());

        model.put("competenciaDto", competenciaDto);
        model.put("competencias", competenciaService.listarPorPlan(plan));
        return "competencia";
    }
	
	@RequestMapping("producto")
	public String producto(Map<String, Object> model) {

        Plan plan = planService.listarPorId(1);
        log.info("plan...");

        ProductoDto productoDto = new ProductoDto();
        productoDto.setProductos(productoService.listarPorPlan(plan));
        System.out.println("producto"+productoDto.getProductos());

        model.put("productoDto", productoDto);
		model.put("productos", productoDto.getProductos());

		return "producto";
	}

    @RequestMapping("guardarProductos")
    public String guardarProductos(Map<String, Object> model, @ModelAttribute ProductoDto productoDto) {
        log.info("guardando..."+productoDto.getProductos());
        productoService.guardar(productoDto.getProductos());
        Plan plan = planService.listarPorId(1);

        model.put("producto", productoDto);
        model.put("productos", productoService.listarPorPlan(plan));
        return "producto";
    }

	@RequestMapping("segmentos")
	public String segmentos(Map<String, Object> model) {

		return "segmentos";
	}
	
	@RequestMapping("plaza")
	public String plaza(Map<String, Object> model) {
		System.out.println("plaza");
		return "plaza";
	}
	
	@RequestMapping("precios")
	public String precios(Map<String, Object> model) {
		System.out.println("precios");
        Plan plan = planService.listarPorId(1);
        PrecioDto precioDto = new PrecioDto();
        precioDto.setPrecios(precioService.listarPorPlan(plan));

        model.put("precioDto", precioDto);
        model.put("precios", precioDto.getPrecios());
		return "precios";
	}

    @RequestMapping("guardarPrecios")
    public String guardarPrecios(Map<String, Object> model, @ModelAttribute PrecioDto precioDto) {
        log.info("guardando..."+precioDto.getPrecios());
        precioService.guardar(precioDto.getPrecios());
        Plan plan = planService.listarPorId(1);

        model.put("precioDto", precioDto);
        model.put("precios", precioService.listarPorPlan(plan));
        return "precios";
    }

	@RequestMapping("promocion")
	public String promocion(Map<String, Object> model) {

	    System.out.println("promocion");
        Plan plan = planService.listarPorId(1);
        PromocionDto promocionDto = new PromocionDto();
        promocionDto.setPromociones(promocionService.listarPorPlan(plan));

        model.put("promocionDto", promocionDto);
        model.put("promociones", promocionDto.getPromociones());

		return "promocion";
	}

    @RequestMapping("guardarPromocion")
    public String guardarPromocion(Map<String, Object> model, @ModelAttribute PromocionDto promocionDto) {
        log.info("guardando..."+promocionDto.getPromociones());
        promocionService.guardar(promocionDto.getPromociones());
        Plan plan = planService.listarPorId(1);

        model.put("promocionDto", promocionDto);
        model.put("promociones", promocionService.listarPorPlan(plan));
        return "promocion";
    }
	
	@RequestMapping("ventas")
	public String ventas(Map<String, Object> model) {
		System.out.println("ventas");
		return "ventas";
	}

    @RequestMapping("calendario")
    public String calendario(Map<String, Object> model) {
        System.out.println("calendario");
        return "calendario";
    }
	
}
