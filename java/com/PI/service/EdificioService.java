package com.PI.service;

import java.util.List;

import com.PI.entity.Edificio;

public interface EdificioService {
	
	public List<Edificio> listaEdicio();
	
	public Edificio insertaEdificio(Edificio obj);

}
