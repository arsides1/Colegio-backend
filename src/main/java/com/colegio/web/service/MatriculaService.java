package com.colegio.web.service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.colegio.web.model.Alumno;
import com.colegio.web.model.Matricula;
import com.colegio.web.model.Seccion;

public interface MatriculaService {
	 
	/* Optional<Profesor> buscarProfesorPorCodigo(String codigo);

	 Optional<Alumno> buscarAlumnoPorCodigo(String codigo);

	
	 void registrarMatricula(Matricula matricula);
	 void actualizarMatricula(Matricula matriculaId);
	 public abstract Collection<Matricula> findAll();
	 public abstract Matricula findById(Long id);
	 public abstract void delete(Long id);*/
	Optional<Alumno> buscarAlumnoPorCodigo(String codigo);

	public abstract void insert(Matricula matricula);

	public abstract void update(Matricula matricula);

	public abstract void delete(Long matriculaId);

	public abstract Matricula findById(Long matriculaId);
	
	 List<Matricula> listarMatricula();

	public abstract Collection<Matricula> findAll();
	List <Seccion> listarSecciones();

}
