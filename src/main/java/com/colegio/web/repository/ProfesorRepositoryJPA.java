package com.colegio.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.colegio.web.model.Profesor;

@Repository
public interface ProfesorRepositoryJPA extends JpaRepository<Profesor, Long>  {
	
	//Optional<Profesor> findByCodigo(String codigo);

	
}
