package com.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PI.entity.Opcion;
import com.PI.entity.Rol;
import com.PI.entity.Usuario;
import com.PI.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repository.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public List<Usuario> listarTodos() {
		return repository.findAll();
	}

}
