package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Departamento;
import com.PI.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public List<Departamento> listaDepartamento() {
		
		return departamentoRepository.findAll();
	}

	@Override
	public Departamento insertaEdificio(Departamento obj) {
		
		return departamentoRepository.save(obj);
	}
	
	

}
