package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Salon;

@Repository
public interface RepositorioSalones extends CrudRepository<Salon, Long> {
	
	List<Salon> findAll();
	
	@Query("SELECT s FROM Salon s JOIN s.usuarios u")
	List<Salon> joinSalonesUsuarios();
	
	@Query("SELECT s, u FROM Salon s JOIN s.usuarios u")
	List<Object[]> joinSalonesUsuarios2();
	/*
	 * lista = [
	 * 	
	 * 	{	[0 = salon,
	 * 		 1 = usuario]
	 *  },
	 *  
	 *  {	[0 = salon,
	 * 		 1 = usuario]
	 *  },
	 *  
	 *  {	[0 = salon,
	 * 		 1 = usuario]
	 *  }
	 * 
	 * ]
	 * */
	
	
}
