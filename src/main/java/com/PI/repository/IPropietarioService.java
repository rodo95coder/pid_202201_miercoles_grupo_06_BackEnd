package com.PI.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.PI.entity.Propietario;


public interface IPropietarioService {

	public List<Propietario>listar();
	public Optional<Propietario>listarId(int codigo_propietario);
	public Propietario findOne(int codigo_propietario);
	public int save(Propietario p);
	public void delete(int codigo_propietario);
	public Page<Propietario> findAll(Pageable pageable);	
}
