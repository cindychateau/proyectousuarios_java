package com.codingdojo.cynthia.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuario {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	//@GetMapping("/")
	public String despliegaHome() {
		String respuesta = "";
		String usuarios[] = {"Elena", "Juana", "Pablo", "Pedro"}; 
		
		for(int i=0; i<usuarios.length; i++) {
			respuesta += "<h2>"+usuarios[i]+"</h2>";
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	//@RequestParam(value="nombre") -> URL?nombre=
	//String name -> el valor que obtuvimos del parámetro
	public String helloNombre(@RequestParam(value="nombre") String name) {
		String respuesta = "<h1> Hello "+name+"</h1>";
		return respuesta;
	}
	
	@RequestMapping(value="/hello/{nombre}", method=RequestMethod.GET)
	public String helloNombrePath(@PathVariable("nombre") String name) {
		String respuesta = "<h1> Hola "+name+"</h1>";
		return respuesta;
	}
	
	
	
}
