package com.PI.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.PI.entity.Propietario;
import com.PI.service.PropietarioService;
import com.PI.util.appSetting;

@RestController
@RequestMapping("/url/propietario")
@CrossOrigin(origins = appSetting.URL_CROSS_ORIGIN)
public class PropietarioController {

	@Autowired
	private PropietarioService propietarioService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaTodosPropietario(){
		List<Propietario> lista = propietarioService.listaPropietario();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarPropietario(@RequestBody Propietario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			Propietario objSalida = propietarioService.insertaPropietario(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR");
			} else {
				salida.put("mensaje", "REGISTRO EXITOSO");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","No se registró, consulte con el administrador");
		}
		return ResponseEntity.ok(salida);
		
	}
	
}
