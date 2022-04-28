package com.PI.service;

import java.util.List;

import com.PI.entity.Visitantes;





public interface VisitanteService {
	
	public abstract List<Visitantes> listaVisitantes();

	public abstract Visitantes insertaVisitante(Visitantes obj);
	public abstract Visitantes insertaActualizaVisi(Visitantes obj);
}
