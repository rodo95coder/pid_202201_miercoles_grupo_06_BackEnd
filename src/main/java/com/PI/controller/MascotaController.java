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

import com.PI.entity.Mascota;

import com.PI.service.MascotaService;

import com.PI.util.appSetting;

@RestController
@RequestMapping("/url/mascota")
@CrossOrigin(origins = appSetting.URL_CROSS_ORIGIN)
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listaTodosMascota(){
		List<Mascota> lista = mascotaService.listaMascota();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarMascota(@RequestBody Mascota obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			Mascota objSalida = mascotaService.inserMascota(obj);
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
