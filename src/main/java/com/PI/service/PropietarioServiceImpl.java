package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Propietario;
import com.PI.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Override
	public List<Propietario> listaPropietario() {
		
		return propietarioRepository.findAll();
	}

	@Override
	public Propietario insertaPropietario(Propietario obj) {
		
		return propietarioRepository.save(obj);
	}
	
	

}
