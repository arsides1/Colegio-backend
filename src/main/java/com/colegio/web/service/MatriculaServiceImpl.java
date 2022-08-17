package com.colegio.web.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.colegio.web.model.Seccion;
import com.colegio.web.repository.SeccionRepositoryJPA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.web.model.Alumno;
import com.colegio.web.model.Matricula;
import com.colegio.web.repository.AlumnoRepositoryJPA;
import com.colegio.web.repository.MatriculaRepositoryJPA;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MatriculaServiceImpl implements MatriculaService {

	
	/*private  AlumnoRepositoryJPA alumnoRepo;
	
    private  ProfesorRepositoryJPA profesorRepo;*/
    private final MatriculaRepositoryJPA matriculaRepo;
	private final AlumnoRepositoryJPA alumnoRepo;

	private final SeccionRepositoryJPA seccionRepo;

	@Override
	public Optional<Alumno> buscarAlumnoPorCodigo(String codigo) {
		return alumnoRepo.findByCodigo(codigo);
	}



	@Override
	public void insert(Matricula matricula) {
		LocalDate fechaActual = LocalDate.now();
		matricula.setFechmatri(fechaActual);
		 matriculaRepo.save(matricula);
		
	}
	@Override
	public void update(Matricula matricula) {
		LocalDate fechaActual = LocalDate.now();
		matricula.setFechmatri(fechaActual);
		matriculaRepo.save(matricula);
	}
	@Override
	public void delete(Long matriculaId) {
		 matriculaRepo.deleteById(matriculaId);
		
	}
	@Override
	public Matricula findById(Long matriculaId) {
		return matriculaRepo.findById(matriculaId).orElse(null);
	
	}
	@Override
	public Collection<Matricula> findAll() {
		return (Collection<Matricula>) matriculaRepo.findAll();
	}

	@Override
	public List<Seccion> listarSecciones() {
		List<Seccion>secciones = StreamSupport.stream(
				this.seccionRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return secciones;
	}

	@Override
	public List<Matricula> listarMatricula() {
		List<Matricula>matriculas = StreamSupport.stream(
				this.matriculaRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return matriculas;
	}
    
    /*
    
	@Override
	public Optional<Profesor> buscarProfesorPorCodigo(String codigo) {
		return profesorRepo.findByCodigo(codigo);
	}

	

	@Override
	public Optional<Alumno> buscarAlumnoPorCodigo(String codigo) {
		return alumnoRepo.findByCodigo(codigo);
	}
	
	
	
	@Override
	public void registrarMatricula(Matricula matricula) {
		
       
		matriculaRepo.save(matricula);
		
	}
	@Override
	public void actualizarMatricula(Matricula matriculaId) {
		matriculaRepo.save(matriculaId);
		
	}
	@Override
	public Collection<Matricula> findAll() {
		return (Collection<Matricula>) matriculaRepo.findAll();
	}



	@Override
	public Matricula findById(Long id) {
		return matriculaRepo.findById(id).orElse(null);
	}



	@Override
	public void delete(Long id) {
		matriculaRepo.deleteById(id);
	}
    */

}
