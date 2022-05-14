package com.PI.service;

import java.util.List;

import com.PI.entity.Propietario;

public interface PropietarioService {

	public List<Propietario> listaPropietario();
	
	public Propietario insertaPropietario(Propietario obj);
}
