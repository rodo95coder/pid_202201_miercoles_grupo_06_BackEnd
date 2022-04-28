package com.PI.controller;


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

import com.PI.entity.Edificio;
import com.PI.service.EdificioService;
import com.PI.util.appSetting;


@RestController
@RequestMapping("/url/edificio")
@CrossOrigin(origins = appSetting.URL_CROSS_ORIGIN)
public class EdificioController {
	
	@Autowired
	private EdificioService edificioService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Edificio>> listaTodosDepartamento(){
		List<Edificio> lista = edificioService.listaEdicio();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarProducto(@RequestBody Edificio obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Edificio objSalida = edificioService.insertaEdificio(obj);
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
