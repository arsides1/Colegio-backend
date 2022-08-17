package com.colegio.web.service;

import com.colegio.web.model.Alumno;
import com.colegio.web.model.Grado;
import com.colegio.web.repository.AlumnoRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class AlumnoServiceImpl implements AlumnoService {


	private final AlumnoRepositoryJPA alumnoRepo;



	@Override
	public List<Alumno> listarAlumno() {
		List<Alumno>alumno = StreamSupport.stream(
				this.alumnoRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return alumno;
	}
}
