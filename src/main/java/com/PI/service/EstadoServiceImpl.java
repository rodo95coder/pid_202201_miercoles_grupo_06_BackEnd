package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Estado;
import com.PI.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> listaEstado() {
		
		return estadoRepository.findAll();
	}

	@Override
	public Estado innsertaEstado(Estado obj) {
		
		return estadoRepository.save(obj);
	}

	
	
}
