package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Edificio;
import com.PI.repository.EdificioRepository;

@Service
public class EdificioServiceImpl implements EdificioService {
	
	@Autowired
	private EdificioRepository edificioRepository;
	
	@Override
	public List<Edificio> listaEdicio() {
		
		return edificioRepository.findAll();
	}

	
	@Override
	public Edificio insertaEdificio(Edificio obj) {
		
		return edificioRepository.save(obj);
	}

}
