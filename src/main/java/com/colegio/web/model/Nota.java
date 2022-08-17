package com.colegio.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="nota")
public class Nota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idnota;
	
	
	@ManyToOne(fetch= FetchType.LAZY, optional = false)
	//fk
	@JoinColumn(name = "idalum",referencedColumnName = "idalum")
	@JsonProperty(access = Access.WRITE_ONLY)	
	private Alumno idalum;
	
	
	@ManyToOne
	//fk
	@JoinColumn(name = "idcur",referencedColumnName = "idcur")
	
	private Curso idcur;
	
	@ManyToOne
	//fk
	@JoinColumn(name = "idpro",referencedColumnName = "idpro")
	private Profesor idpro;
	
	@Column (length = 2, nullable = false)
	private Integer nota1;
	
	@Column (length = 2, nullable = false)
	private Integer nota2;
	
	@Column (length = 2, nullable = false)
	private Integer nota3;
	
	@Column (length = 2, nullable = false)
	private Integer Notafin;
	
}
