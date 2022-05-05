package com.PI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PI.entity.Departamento;
import com.PI.entity.Edificio;
import com.PI.service.DepartamentoService;
import com.PI.service.EdificioService;
import com.PI.util.appSetting;



@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = appSetting.URL_CROSS_ORIGIN)
public class UtilController {
	
	@Autowired
	private EdificioService edificioService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/listaEdificio")
	@ResponseBody
	public List<Edificio> listaEdificios() {
		return edificioService.listaEdicio();
	}
	
	@GetMapping("/listadepartamento")
	@ResponseBody
	public List<Departamento> listaDepartamento() {
		return departamentoService.listaDepartamento() ;
	}

}
