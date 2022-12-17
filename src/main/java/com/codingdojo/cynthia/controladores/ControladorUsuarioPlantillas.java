package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorUsuarioPlantillas {
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("titulo", "¡Bienvenidos a Spring!");
		
		ArrayList<String> usuarios = new ArrayList<String>();
		
		usuarios.add("Elena");
		usuarios.add("Juana");
		usuarios.add("Pablo");
		usuarios.add("Pedro");
		
		model.addAttribute("usuarios", usuarios);
		
		return "index.jsp";
	}
	
}
