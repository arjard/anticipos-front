package com.ph.anticipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph.anticipos.service.AnticiposService;

@Controller
@RequestMapping(value = "/anticipos")
public class listadoController {
	
	@Autowired
	AnticiposService anticiposService;
	
	@GetMapping(value = "/list")
	public String goList(Model modelo) {
		
		modelo.addAttribute("listadoAnticipos", anticiposService.getAnticipos());
		
		return "listado";
	}

}
