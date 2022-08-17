package com.colegio.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alumno")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalum;

	@Column(length = 5, unique=true, nullable = false)
	private String codigo;

	@Column(length = 50, nullable = false)
	private String nombre;

	@Column(length = 50, nullable = false)
	private String apepa;

	@Column(length = 50, nullable = false)
	private String apema;

	@Column(length = 8, unique = true, nullable = false)
	private String dni;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fechna;

	@Column(length = 1, nullable = false)
	private String genero;

	@Column(length = 9)
	private String telefono;

	@Column( nullable = false)
	private String estado;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idalum")
	@JsonBackReference(value = "alum_not")
	private List<Nota> notaList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idalum")
	@JsonBackReference(value = "alum_matri")
	private List<Matricula> matriculaList;

}
