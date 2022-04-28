package com.PI.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.PI.entity.Propietario;



public interface IPropietario extends CrudRepository<Propietario, Integer> {

	Page<Propietario> findAll(Pageable pageable);

}
