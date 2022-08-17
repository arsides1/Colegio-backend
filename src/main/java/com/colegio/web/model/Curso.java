package com.colegio.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcur;
	
	@Column( length = 50, nullable = false)
	private String nombre; 
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idcur")
	@JsonBackReference(value="cur_not")
	private List<Nota> notaList;
	
	//@JsonIgnore
	//@JsonBackReference
	@ManyToMany(mappedBy = "cursoList")
	private List<Profesor> profesorList;
	
	
	@ManyToMany(mappedBy = "cursoList")
	private List<Grado> gradoList;
}
