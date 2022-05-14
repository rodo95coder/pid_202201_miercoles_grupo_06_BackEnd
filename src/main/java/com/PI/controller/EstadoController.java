package com.PI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PI.entity.Estado;

import com.PI.service.EstadoService;

@RestController
@RequestMapping("/url/estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Estado>> listaTodosEstado(){
		List<Estado> lista = estadoService.listaEstado();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarEstado(@RequestBody Estado obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Estado objSalida = estadoService.innsertaEstado(obj);
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
