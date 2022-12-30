package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller
public class ControladorSalones {

	private final Servicios servicio;

	public ControladorSalones(Servicios servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/salones")
	public String salones(Model model) {
		List <Salon> salones = servicio.find_salones();
		model.addAttribute("salones", salones);
		
		model.addAttribute("salones_join", servicio.find_salones_join());
		
		return "/salones/index.jsp";
	}
	
	@GetMapping("/salones/{id}")
	public String show_salon(@PathVariable("id") Long id,
							 Model model) {
		Salon salon = servicio.find_salon(id);
		model.addAttribute("salon", salon);
		
		return "/salones/show.jsp";
		
	}
}
