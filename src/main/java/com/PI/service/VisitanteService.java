package com.PI.service;

import java.util.List;

import com.PI.entity.Visitante;

public interface VisitanteService {
	
	public List<Visitante> listaVisitante();
	
	public Visitante insertaVisitante(Visitante obj);

}
