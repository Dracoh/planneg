package com.sv.planneg.mercado.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Log4j2
@Controller
public class MainController {

	@RequestMapping("index")
	public String index(Map<String, Object> model) {
		return "index";
	}

}
