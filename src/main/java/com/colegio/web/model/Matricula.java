package com.colegio.web.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "matricula")
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmatri;
	
	
	@ManyToOne
	//fk
	@JoinColumn(name = "idalum",referencedColumnName = "idalum", unique=true)
	private Alumno idalum;
	
	@ManyToOne	
	//fk
	@JoinColumn(name = "idgra",referencedColumnName = "idgra")

	private Grado idgra;
	
	
	@ManyToOne
	//fk
	@JoinColumn(name = "idsec",referencedColumnName = "idsec")
	private Seccion idsec;
	
	@Column
	//@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechmatri;


	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idmatri")
	  @JsonBackReference(value="Pagomatri_matri")
	private List<PagoMatricula>pagomatriculaList;


}
