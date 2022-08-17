package com.colegio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.colegio.web.model.Seccion;

@Repository
public interface SeccionRepositoryJPA extends JpaRepository<Seccion, Long>  {

}
