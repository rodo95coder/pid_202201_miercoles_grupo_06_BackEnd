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

import com.PI.entity.Visitante;
import com.PI.service.VisitanteService;
import com.PI.util.appSetting;

@RestController
@RequestMapping("/url/visitante")
@CrossOrigin(origins = appSetting.URL_CROSS_ORIGIN)
public class VisitanteController {

	@Autowired
	private VisitanteService visitanteService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitante>> listaTodosPropietario(){
		List<Visitante> lista = visitanteService.listaVisitante();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarVisitante(@RequestBody Visitante obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setFechaRegistro(new Date());
			Visitante objSalida = visitanteService.insertaVisitante(obj);
			if (objSalida == null) {
				if(obj.getDni()!=null)
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
