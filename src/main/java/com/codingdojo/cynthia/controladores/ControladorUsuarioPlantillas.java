package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/registro")
	//@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String registro() {
		return "registro.jsp";
	}
	
	@RequestMapping(value="/registrar", method=RequestMethod.POST)
	public String registrar(@RequestParam(value="nombre") String name,
							@RequestParam(value="email") String email,
							HttpSession session, /*Se agrega cuando queremos guardar información en sesión*/
							RedirectAttributes flash){ /*Se agrega para generar un mensaje de validación*/
		
		System.out.println(name);
		System.out.println(email);
		
		if( name.equals("") ) {
			flash.addFlashAttribute("errorNombre", "Por favor ingresa el nombre de tu usuario.");
			return "redirect:/registro";
		}
		
		if( email.equals("") ) {
			flash.addFlashAttribute("errorNombre", "Por favor ingresa el email de tu usuario.");
			return "redirect:/registro";
		}
		
		session.setAttribute("nombre", name);
		
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
}
