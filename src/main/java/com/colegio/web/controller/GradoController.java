package com.colegio.web.controller;

import com.colegio.web.model.Alumno;
import com.colegio.web.model.Grado;
import com.colegio.web.model.Matricula;
import com.colegio.web.model.Seccion;
import com.colegio.web.service.GradoService;
import com.colegio.web.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/Grado")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GradoController {
	
	private final GradoService gradoService;

	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		List<Grado> grados = this.gradoService.listarGrado();
		return ResponseEntity.ok(grados);
		/*Collection<Matricula> matricula = gradoService.findAll();
		return new ResponseEntity<>(matricula, HttpStatus.OK);*/
	}


	/*@GetMapping("/buscar/{id}")

	public ResponseEntity<?> buscar(@PathVariable(name = "id") Long gradoaId) {
		Grado grado = gradoService.findById(gradoId);
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
	
	/*
	
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
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}


	@GetMapping("/buscando/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable(name = "codigo") String codigo) {
		Optional<Alumno> estudianteEncontrado = matriculaService.buscarAlumnoPorCodigo(codigo);
		if(!estudianteEncontrado.isPresent()){
			return new ResponseEntity<>("No se encontró estudiante con código: "+ codigo, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(codigo, HttpStatus.OK);
	}

	@PostMapping("/registrar-matricula")
	public ResponseEntity<?> registrarAsistencia(@RequestBody Matricula matricula) {

		Optional<Alumno> estudianteEncontrado = matriculaService
				.buscarAlumnoPorCodigo(matricula.getIdalum().getCodigo());

		if(!estudianteEncontrado.isPresent()){
			return new ResponseEntity<>("No se encontró estudiante con código: "+ matricula.getIdalum().getCodigo(), HttpStatus.NOT_FOUND);
		}
		if(estudianteEncontrado.isPresent()){
			return new ResponseEntity<>("El estudiante ya esta matriculado: "+ matricula.getIdalum().getCodigo(), HttpStatus.NOT_FOUND);
		}
		matricula.setIdalum(estudianteEncontrado.get());
		matriculaService.insert(matricula);

		return new ResponseEntity<>("Matricula registrada, estudiante con código: "+ matricula.getIdalum().getCodigo(),HttpStatus.CREATED);

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
			return new ResponseEntity<>("Se borro correctamente", HttpStatus.ACCEPTED);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro matricula con ese id");

	}*/
}
