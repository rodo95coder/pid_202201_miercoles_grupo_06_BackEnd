package com.PI.service;

import java.util.List;

import com.PI.entity.Mascota;

public interface MascotaService {
	
	public List<Mascota> listaMascota();
	
	public Mascota inserMascota(Mascota obj);

}
