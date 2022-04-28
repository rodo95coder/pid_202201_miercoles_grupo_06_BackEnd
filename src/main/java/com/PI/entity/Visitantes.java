package com.PI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "visitantes")
public class Visitantes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisitante;
	private String nombre;
	private String apellido;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechanaci;
	private String correo;
	private int telefono;
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechanavi() {
		return fechanaci;
	}
	public void setfechanaci(Date fechanaci) {
		this.fechanaci = fechanaci;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}



