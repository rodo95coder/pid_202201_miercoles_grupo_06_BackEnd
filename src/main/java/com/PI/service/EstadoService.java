package com.PI.service;

import java.util.List;

import com.PI.entity.Estado;

public interface EstadoService {

	public List<Estado> listaEstado();
	
	public Estado innsertaEstado(Estado obj);
}
