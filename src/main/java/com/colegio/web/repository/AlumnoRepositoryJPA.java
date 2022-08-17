package com.colegio.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.web.model.Alumno;




@Repository
public interface AlumnoRepositoryJPA extends JpaRepository<Alumno, Long>  {
	
	Optional<Alumno> findByCodigo(String codigo);
	
}
