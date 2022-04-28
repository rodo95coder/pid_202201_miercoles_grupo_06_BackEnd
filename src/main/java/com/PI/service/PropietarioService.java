package com.PI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PI.entity.Propietario;
import com.PI.repository.IPropietarioService;


@Service
public class PropietarioService implements IPropietarioService{
	@Autowired
	private IPropietario data;

	@Override
	public List<Propietario> listar() {

		return (List<Propietario>)data.findAll();
	}

	@Override
	public Optional<Propietario> listarId(int codigo_propietario) {
	
		
		return data.findById(codigo_propietario);
	}

	@Override
	public int save(Propietario p) {
		int res=0;
		Propietario propietario=data.save(p);
		if(!propietario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int codigo_propietario) {
		// TODO Auto-generated method stub
		data.deleteById(codigo_propietario);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Propietario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return data.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Propietario findOne(int codigo_propietario) {
		return data.findById(codigo_propietario).orElse(null);
	}

	
	
	

}
