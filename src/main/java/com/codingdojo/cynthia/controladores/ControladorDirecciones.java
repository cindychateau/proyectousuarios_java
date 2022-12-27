package com.codingdojo.cynthia.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller
public class ControladorDirecciones {
	
	private final Servicios servicio;

	public ControladorDirecciones(Servicios servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/direcciones/new")
	public String new_direccion(@ModelAttribute("direccion") Direccion direccion,
								Model model) {
		
		List<Usuario> usuarios = servicio.usuarios_sin_direccion();
		
		model.addAttribute("usuarios", usuarios);
		
		return "/direcciones/new.jsp";
	}
	
	@PostMapping("/direcciones/create")
	public String create_direccion(@Valid @ModelAttribute("direccion") Direccion direccion,
								   BindingResult result) {
		
		if(result.hasErrors()) {
			return "/direcciones/new.jsp";
		} else {
			servicio.save_direccion(direccion);
			return "redirect:/dashboard";
		}
		
	}
	
}
