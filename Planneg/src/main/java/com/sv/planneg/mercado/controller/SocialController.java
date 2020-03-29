package com.sv.planneg.mercado.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Log4j2
@Controller
public class SocialController {

	@RequestMapping("emprendimiento")
	public String emprendimiento(Map<String, Object> model) {
		return "emprendimiento";
	}

	@RequestMapping("organizacional")
	public String organizacional(Map<String, Object> model) {
		return "emprendimiento";
	}

	@RequestMapping("operativo")
	public String operativo(Map<String, Object> model) {
		return "emprendimiento";
	}

	@RequestMapping("social")
	public String social(Map<String, Object> model) {
		return "emprendimiento";
	}

	@RequestMapping("impacto")
	public String impacto(Map<String, Object> model) {
		return "emprendimiento";
	}

}
