package com.colegio.web.service;


import com.colegio.web.model.Alumno;
import com.colegio.web.model.Matricula;
import com.colegio.web.model.Seccion;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SeccionService {

	List <Seccion> listarSecciones();
	public abstract Collection<Seccion> findAll();
}
