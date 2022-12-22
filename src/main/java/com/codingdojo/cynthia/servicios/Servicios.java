package com.codingdojo.cynthia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	private final RepositorioUsuarios repositorio_usuarios;

	public Servicios(RepositorioUsuarios repositorio_usuarios) {
		this.repositorio_usuarios = repositorio_usuarios;
	}
	
	//Me regresa un a lista de TODOS los usuarios
	public List<Usuario> find_usuarios() {
		return repositorio_usuarios.findAll();
	}
	
	//Guardamos usuario
	public Usuario save_usuario(Usuario nuevoUsuario) {
		//Nosotros vamos a recibir un objeto de usuario que NO tiene ID
		return repositorio_usuarios.save(nuevoUsuario);
	}
	
	//Encontrar un usuario en base a su ID
	public Usuario find_usuario(Long id) {
		Optional<Usuario> optionalUser = repositorio_usuarios.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	//Actualizamos usuario
	public Usuario update_usuario(Usuario usuario) {
		//Objeto de usuario que SI tiene id
		return repositorio_usuarios.save(usuario);
	}
	
	//Borrar usuario
	public void delete_usuario(Long id) {
		repositorio_usuarios.deleteById(id);
	}
	
}