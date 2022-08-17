package com.colegio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.web.model.Grado;


@Repository
public interface GradoRepositoryJPA extends JpaRepository<Grado, Long>  {

}
