package com.colegio.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "seccion")
public class Seccion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsec;
	
	@Column(length = 50, unique=true,nullable = false)
	private String descripcion;
	 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idsec")
	  @JsonBackReference(value="Sec_matri")
	private List<Matricula>matriculaList;
}
