package com.codingdojo.cynthia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioDirecciones;
import com.codingdojo.cynthia.repositorios.RepositorioHobbies;
import com.codingdojo.cynthia.repositorios.RepositorioSalones;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	private final RepositorioUsuarios repositorio_usuarios;
	private final RepositorioDirecciones repositorio_direcciones;
	private final RepositorioSalones repositorio_salones;
	private final RepositorioHobbies repositorio_hobbies;

	public Servicios(RepositorioUsuarios repositorio_usuarios,
					 RepositorioDirecciones repositorio_direcciones,
					 RepositorioSalones repositorio_salones,
					 RepositorioHobbies repositorio_hobbies) {
		this.repositorio_usuarios = repositorio_usuarios;
		this.repositorio_direcciones = repositorio_direcciones;
		this.repositorio_salones = repositorio_salones;
		this.repositorio_hobbies = repositorio_hobbies;
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
	
	//Guardar una direccion
	public Direccion save_direccion(Direccion nuevaDireccion) {
		return repositorio_direcciones.save(nuevaDireccion);
	}
	
	//Obtener todos los usuarios que NO tienen dirección
	public List<Usuario> usuarios_sin_direccion() {
		return repositorio_usuarios.findByDireccionIdIsNull();
	}
	
	//Obtener todos los salones
	public List<Salon> find_salones() {
		return repositorio_salones.findAll();
	}
	
	//Obtener un salon en base a su ID
	public Salon find_salon(Long id) {
		return repositorio_salones.findById(id).orElse(null);
	}
	
	//Obtener todos los hobbies
	public List<Hobby> find_hobbies() {
		return repositorio_hobbies.findAll();
	}
	
	//Obtener un hobby
	public Hobby find_hobby(Long id) {
		return repositorio_hobbies.findById(id).orElse(null);
	}
	
}
