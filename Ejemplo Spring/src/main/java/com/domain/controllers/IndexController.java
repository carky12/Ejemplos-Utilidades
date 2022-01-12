package com.domain.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/detalle")
	public String goIndex(Model model) {
		List<String> categorias = new ArrayList<String>();
		
		categorias.add("vestidos");
		categorias.add("pantacas");
		categorias.add("juguetes");
		categorias.add("perfumes");
		
		model.addAttribute("categoriasList", categorias);
		return "detalle";
	}
	
	@RequestMapping("/")
	public String goDetalle(Model model) {
		model.addAttribute("mensaje", "Mensaje desde el IndexController hasta el index.jsp");
		return "index";
	}
	
	
}
