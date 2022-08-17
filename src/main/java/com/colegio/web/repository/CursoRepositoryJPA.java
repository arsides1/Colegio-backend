package com.colegio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.web.model.Curso;


@Repository
public interface CursoRepositoryJPA extends JpaRepository<Curso, Long>  {

}
