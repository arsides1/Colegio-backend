package com.colegio.web.repository;

import com.colegio.web.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;


import com.colegio.web.model.Matricula;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatriculaRepositoryJPA extends JpaRepository<Matricula, Long>  {

}
