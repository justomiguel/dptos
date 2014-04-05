package com.dptosweb.model.ciudades;

// Generated Apr 2, 2014 7:45:04 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Provincia generated by hbm2java
 */
@Entity
@Table(name = "provincias")
public class Provincia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private Set<Departamento> departamentos = new HashSet<Departamento>();
	private Set<Localidad> localidades = new HashSet<Localidad>();

	public Provincia() {
	}

	public Provincia(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Provincia(int id, String nombre, Set<Departamento> departamentos,
			Set<Localidad> localidades) {
		this.id = id;
		this.nombre = nombre;
		this.departamentos = departamentos;
		this.localidades = localidades;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Provincia")
	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Provincia")
	public Set<Localidad> getLocalidades() {
		return this.localidades;
	}

	public void setLocalidades(Set<Localidad> localidades) {
		this.localidades = localidades;
	}

}
