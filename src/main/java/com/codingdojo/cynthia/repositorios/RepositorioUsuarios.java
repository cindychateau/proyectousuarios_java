package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	
	//SELECT * FROM users
	List<Usuario> findAll();
	
	//SELECT * FROM users WHERE id = <ID>
	List<Usuario> findById(long id);
	
	//SELECT * FROM users WHERE email = <EMAIL>
	List<Usuario> findByEmail(String email);
	
	//INSERT into users(first_name, last_name, password, email) VALUES (Datos del obj Usuario)
	//UPDATE -> siempre y cuando el objeto tenga id
	Usuario save(Usuario nuevoUsuario);
	
	void deleteById(Long id);
	
	//SELECT * FROM users LEFT JOIN addresses ON usuario_id = users.id WHERE addresses.id = NULL
	List<Usuario> findByDireccionIdIsNull();
	
}
