package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller
public class ControladorHobbies {
	
	private final Servicios servicio;

	public ControladorHobbies(Servicios servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/asignar/{id}")
	public String assign(@PathVariable("id") Long id,
						 Model model) {
		Usuario usuario = servicio.find_usuario(id);
		model.addAttribute("usuario", usuario);
		
		List<Hobby> hobbies = servicio.find_hobbies();
		model.addAttribute("hobbies", hobbies);
		
		return "/hobbies/assign.jsp";
		
	}
	
	@PostMapping("/assign_hobby")
	public String assign_hobby(@RequestParam(value="user_id") Long user_id,
							   @RequestParam(value="hobby_id") Long hobby_id) {
		
		servicio.save_usuario_hobby(user_id, hobby_id);
		return "redirect:/dashboard";
		
	}
	
}
