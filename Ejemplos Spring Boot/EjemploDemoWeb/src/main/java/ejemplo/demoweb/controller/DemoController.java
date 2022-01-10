package ejemplo.demoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ejemplo.demoweb.modelo.Persona;
import ejemplo.demoweb.repository.IPersonaRepository;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepository repo;
	
	@GetMapping("/saluda")
	public String saludo(@RequestParam(name="nombre", required = false, defaultValue = "Sin Nombre") String nombre, Model modelo) {
		repo.save(new Persona(1, nombre));
		
		modelo.addAttribute("nombre", nombre);
		return "saluda";
	}
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("personas", repo.findAll());
		return "saluda";
	}
}
