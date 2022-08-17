package com.colegio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.colegio.web.model.PagoMatricula;

@Repository
public interface PagoMatriculaRepositoryJPA extends JpaRepository<PagoMatricula, Long>  {

}
