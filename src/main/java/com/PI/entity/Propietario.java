package com.PI.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Propietario")

public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_propietario;
	private int DNI;
	private String nombre_Propietario;
	private String primeraapellido_Propietario;
	private String segundoapellido_Propietario;
	private String telefono_Propietario;
	private String celular_Propietario;
	private Date fecha_registro;
	private String foto;
	public Propietario() {
		
	}
	
	public Propietario(int codigo_propietario, int dNI, String nombre_Propietario, String primeraapellido_Propietario,
			String segundoapellido_Propietario, String telefono_Propietario, String celular_Propietario,
			Date fecha_registro) {
		super();
		this.codigo_propietario = codigo_propietario;
		this.DNI = dNI;
		this.nombre_Propietario = nombre_Propietario;
		this.primeraapellido_Propietario = primeraapellido_Propietario;
		this.segundoapellido_Propietario = segundoapellido_Propietario;
		this.telefono_Propietario = telefono_Propietario;
		this.celular_Propietario = celular_Propietario;
		this.fecha_registro = fecha_registro;
	}

	public int getCodigo_propietario() {
		return codigo_propietario;
	}

	public void setCodigo_propietario(int codigo_propietario) {
		this.codigo_propietario = codigo_propietario;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getNombre_Propietario() {
		return nombre_Propietario;
	}

	public void setNombre_Propietario(String nombre_Propietario) {
		this.nombre_Propietario = nombre_Propietario;
	}

	public String getPrimeraapellido_Propietario() {
		return primeraapellido_Propietario;
	}

	public void setPrimeraapellido_Propietario(String primeraapellido_Propietario) {
		this.primeraapellido_Propietario = primeraapellido_Propietario;
	}

	public String getSegundoapellido_Propietario() {
		return segundoapellido_Propietario;
	}

	public void setSegundoapellido_Propietario(String segundoapellido_Propietario) {
		this.segundoapellido_Propietario = segundoapellido_Propietario;
	}

	public String getTelefono_Propietario() {
		return telefono_Propietario;
	}

	public void setTelefono_Propietario(String telefono_Propietario) {
		this.telefono_Propietario = telefono_Propietario;
	}

	public String getCelular_Propietario() {
		return celular_Propietario;
	}

	public void setCelular_Propietario(String celular_Propietario) {
		this.celular_Propietario = celular_Propietario;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


}
