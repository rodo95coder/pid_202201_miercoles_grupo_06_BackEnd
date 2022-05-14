package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Mascota;
import com.PI.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	private MascotaRepository mascotaRepository;
	
	@Override
	public List<Mascota> listaMascota() {
		
		return mascotaRepository.findAll();
	}

	@Override
	public Mascota inserMascota(Mascota obj) {
		
		return mascotaRepository.save(obj);
	}

	
}
