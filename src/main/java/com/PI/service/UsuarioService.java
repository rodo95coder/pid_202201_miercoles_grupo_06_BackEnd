package com.PI.service;

import java.util.List;

import com.PI.entity.Opcion;
import com.PI.entity.Rol;
import com.PI.entity.Usuario;

public interface UsuarioService {

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
	
	public abstract List<Usuario> listarTodos();

}
