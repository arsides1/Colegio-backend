package com.colegio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.colegio.web.model.Nota;

@Repository
public interface NotaRepositoryJPA extends JpaRepository<Nota, Long>  {

}
