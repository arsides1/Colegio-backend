package com.colegio.web.service;

import com.colegio.web.model.Alumno;
import com.colegio.web.model.Matricula;
import com.colegio.web.model.Seccion;
import com.colegio.web.repository.AlumnoRepositoryJPA;
import com.colegio.web.repository.MatriculaRepositoryJPA;
import com.colegio.web.repository.SeccionRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class SeccionServiceImpl implements SeccionService {


	private final SeccionRepositoryJPA seccionRepo;

	@Override
	public List<Seccion> listarSecciones() {
		List<Seccion>secciones = StreamSupport.stream(
				this.seccionRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return secciones;
	}

	@Override
	public Collection<Seccion> findAll() {
		return (Collection<Seccion>) seccionRepo.findAll();
	}

}
