package com.PI.controller;

import java.text.SimpleDateFormat;
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

import com.PI.entity.Visitantes;
import com.PI.service.VisitanteService;
import com.PI.util.Constantes;



@RestController
@RequestMapping("/rest/crudVisitante")
@CrossOrigin(origins = "http://localhost:4200")
public class CrudVisitanteController {

	@Autowired
	private VisitanteService visitanteServi;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitantes>> listaVisitantes() {
		List<Visitantes> lista = visitanteServi.listaVisitantes();
		
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/registrarVisitante")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertarCliente(@RequestBody Visitantes obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Visitantes objSalida = visitanteServi.insertaActualizaVisi(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO );
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	
	
}
