package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller
public class ControladorUsuarioPlantillas {
	
	private final Servicios servicio;
	
	public ControladorUsuarioPlantillas(Servicios servicio) {
		this.servicio = servicio;
	}
	
	
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
	public String dashboard(Model model) {
		
		List <Usuario> usuarios = servicio.find_usuarios();
		
		//Creo variable usuarios que tiene el valor de la lista con objetos de usuario
		model.addAttribute("usuarios", usuarios); 
 		
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String new_user(@ModelAttribute("usuario") Usuario usuario) {
		//En base a lo que el usuario ingrese, va a crear un objeto de usuario
		return "new.jsp";
	}
	
	//@RequestMapping(value="/create", method=RequestMethod.POST)
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("usuario") Usuario usuario,
						 BindingResult result /*Encargado de regresar los mensajes de valid*/ ) {
		
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			servicio.save_usuario(usuario);
			return "redirect:/dashboard";
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete_user(@PathVariable("id") Long id) {
		servicio.delete_usuario(id);
		return "redirect:/dashboard";
	}
	
}
