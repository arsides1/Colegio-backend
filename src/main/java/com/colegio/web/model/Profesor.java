package com.colegio.web.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesor")
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpro;
	
	
	@Column(length = 5, unique=true, nullable = false)
	private String codigo;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String apellidos;
	
	@Column(length = 8, unique=true, nullable = false)
	private String dni;
	
	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fechna;
	
	@Column(length = 1, nullable = false)
	private String genero;
	
	@Column(length = 9, nullable = false)
	private String telefono;


	@Column( nullable = false)
	private String estado;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idpro")
	@JsonBackReference(value="profe_not")
	private List<Nota> notaList;
	
	
	@JoinTable(name = "curso_profesor", joinColumns = {
			@JoinColumn(name = "idpro", referencedColumnName = "idpro") }, inverseJoinColumns = {
					@JoinColumn(name = "idcur", referencedColumnName = "idcur") })
	@ManyToMany
	private List<Curso> cursoList;
	
}
