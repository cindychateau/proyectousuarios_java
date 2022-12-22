package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@RestController
public class ControladorUsuarioAPI {
	
	private final Servicios servicio;

	public ControladorUsuarioAPI(Servicios servicio) {
		this.servicio = servicio;
	}
	
	@RequestMapping(value="/api/usuarios", method=RequestMethod.POST)
	public Usuario crear(@RequestParam(value="first_name") String first_name,
						 @RequestParam(value="last_name") String last_name,
						 @RequestParam(value="email") String email,
						 @RequestParam(value="password") String password) {
		
		Usuario nuevoUsuario = new Usuario(first_name, last_name, email, password);
		return servicio.save_usuario(nuevoUsuario);
		
	}
	
	@RequestMapping(value="/api/usuarios", method=RequestMethod.GET)
	public List<Usuario> todos() {
		return servicio.find_usuarios();
	}
	
	@RequestMapping("/api/usuarios/{id}")
	public Usuario show(@PathVariable("id") Long id) {
		Usuario usuario = servicio.find_usuario(id);
		return usuario;
	}
	
	@RequestMapping(value="/api/usuarios/{id}", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable("id") Long id) {
		servicio.delete_usuario(id);
	}
	
	@RequestMapping(value="/api/usuarios/{id}", method=RequestMethod.PUT)
	public Usuario actualizar(@PathVariable("id") Long id,
							  @RequestParam(value="first_name") String first_name,
							  @RequestParam(value="last_name") String last_name,
							  @RequestParam(value="email") String email,
							  @RequestParam(value="password") String password) {
		Usuario usuario = new Usuario(id, first_name, last_name, email, password);
		return servicio.update_usuario(usuario);
	}
	
	
}
