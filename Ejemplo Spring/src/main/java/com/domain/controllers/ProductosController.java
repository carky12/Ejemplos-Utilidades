package com.domain.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@RequestMapping("/list")
	public String goListarProductos(Model model) {
		
		List<String> categorias = new ArrayList<String>();
		
		categorias.add("vestidos");
		categorias.add("pantacas");
		categorias.add("juguetes");
		categorias.add("perfumes");
		
		model.addAttribute("categoriasList", categorias);
		
		List<String> productos = new ArrayList<String>();
		
		productos.add("camisa");
		productos.add("zapato");
		productos.add("corbata");
		
		model.addAttribute("productosList", productos);
		
		return "productos/listaProductos";
	}

}
