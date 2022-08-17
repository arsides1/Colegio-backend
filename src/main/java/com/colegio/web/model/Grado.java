package com.colegio.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grado")
public class Grado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgra;
	
	@Column (length = 50, nullable = false)
	private String  nomgra;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idgra")
	   @JsonBackReference(value="Gra_matri")
	private List<Matricula> matriculaList;

	
	@JoinTable(name = "grado_curso", joinColumns = {
			@JoinColumn(name = "idgra", referencedColumnName = "idgra") }, inverseJoinColumns = {
					@JoinColumn(name = "idcur", referencedColumnName = "idcur") })
	@ManyToMany
	private List<Curso>cursoList;
	
}
