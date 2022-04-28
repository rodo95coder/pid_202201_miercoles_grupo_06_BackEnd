package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Visitantes;
import com.PI.repository.VisitantesRepo;





@Service
public class VisitantesImpl implements VisitanteService {

	
	
	@Autowired
	private VisitantesRepo repo;
	
	@Override
	public List<Visitantes> listaVisitantes(){
		return repo.findAll();
		
		
	}
	
	@Override
	public Visitantes insertaVisitante(Visitantes obj) {
		return repo.save(obj);
	}

	
	@Override
	public Visitantes insertaActualizaVisi(Visitantes obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}
	
	
	
	
	
	

}
