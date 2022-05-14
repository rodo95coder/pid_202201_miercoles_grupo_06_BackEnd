package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Visitante;

import com.PI.repository.VisitanteRepository;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Override
	public List<Visitante> listaVisitante() {
		
		return visitanteRepository.findAll();
	}

	@Override
	public Visitante insertaVisitante(Visitante obj) {
		
		return visitanteRepository.save(obj);
	}

}
