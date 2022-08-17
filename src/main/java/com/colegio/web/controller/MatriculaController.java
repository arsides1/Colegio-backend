package com.colegio.web.controller;

import java.sql.Date;
import java.util.*;

import com.colegio.web.model.Alumno;
import com.colegio.web.model.Seccion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.colegio.web.model.Matricula;
import com.colegio.web.service.MatriculaService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/Matricula")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MatriculaController {
	
	private final MatriculaService matriculaService;

	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		/*List<Matricula> matriculas = this.matriculaService.listarMatricula();
		return ResponseEntity.ok(matriculas);*/
		Collection<Matricula> matricula = matriculaService.findAll();
		return new ResponseEntity<>(matricula, HttpStatus.OK);
	}

	@GetMapping("/listar-seccion")
	public ResponseEntity<?> listarSecciones() {
		List<Seccion> secciones = this.matriculaService.listarSecciones();
		return ResponseEntity.ok(secciones);
	}

	@GetMapping("/buscar/{id}")

	public ResponseEntity<?> buscar(@PathVariable(name = "id") Long matriculaId) {
		Matricula matricula = matriculaService.findById(matriculaId);
		if (matricula == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Matricula con ese id");

		return new ResponseEntity<>(matricula, HttpStatus.OK);
	}

	
	/*@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Matricula matricula) {

		matriculaService.insert(matricula);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("codigo", "OK");
		respuesta.put("mensaje", "Se creo correctamente el instructor");
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}*/
	
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> agregar(@RequestBody Matricula matricula) {
		Map<String,String>respuesta = new HashMap<>();
		
		try {		
			matriculaService.insert(matricula);
			respuesta.put("codigoRespuesta", "Ok");
			respuesta.put("msjRespuesta","Se creo Satisfactoriamente la nueva Matricula con codigo: " + matricula.getIdmatri());
			respuesta.put("fechaCreacion", new Date(0).toString());
		}
		catch(Exception ex) {

				respuesta.put("CodigoRespuesta", "FAIL");
				respuesta.put("msjRespuesta","Ya se encuentra Matriculado");
		}
		return new ResponseEntity<>( respuesta, HttpStatus.CREATED);
	}


	@GetMapping("/buscando/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable(name = "codigo") String codigo) {
		Optional<Alumno> estudianteEncontrado = matriculaService.buscarAlumnoPorCodigo(codigo);
		if(!estudianteEncontrado.isPresent()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró estudiante con código: "+ codigo);
		}
		return new ResponseEntity<>(estudianteEncontrado, HttpStatus.OK);
	}

	@PostMapping("/registrar-matricula")
	public ResponseEntity<?> registrarAsistencia(@RequestBody Matricula matricula) {

		Optional<Alumno> estudianteEncontrado = matriculaService
				.buscarAlumnoPorCodigo(matricula.getIdalum().getCodigo());

		if(!estudianteEncontrado.isPresent()){
			return new ResponseEntity<>( HttpStatus.NOT_FOUND, HttpStatus.valueOf("No se encontró estudiante con código: "+ matricula.getIdalum().getCodigo()));
		}else{

		}

		if(estudianteEncontrado.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND, HttpStatus.valueOf("El estudiante ya esta matriculado: "+ matricula.getIdalum().getCodigo()));
		}
		matricula.setIdalum(estudianteEncontrado.get());
		matriculaService.insert(matricula);

		return new ResponseEntity<>(HttpStatus.CREATED, HttpStatus.valueOf("Matricula registrada, estudiante con código: "+ matricula.getIdalum().getCodigo()));

	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@PathVariable(name = "id") Long id,
			@RequestBody Matricula matricula) {
		Matricula matriculaActual = matriculaService.findById(id);
			if (matriculaActual != null) {
				matriculaActual.setIdalum(matricula.getIdalum());
				matriculaActual.setIdgra(matricula.getIdgra());
				matriculaActual.setIdsec(matricula.getIdsec());
				matriculaService.update(matriculaActual);
				return new ResponseEntity<>(matriculaActual, HttpStatus.ACCEPTED);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Matricula con ese id");

	}
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable Long id) {
		Matricula matriculaActual = matriculaService.findById(id);
		if (matriculaActual != null) {
			matriculaService.delete(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

	}
}
