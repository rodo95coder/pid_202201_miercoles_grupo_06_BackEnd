package com.PI.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.PI.entity.Propietario;
import com.PI.repository.IPropietarioService;
import com.PI.util.PageRender;





@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IPropietarioService service;
	
	@GetMapping(value = "/ver/{codigo_propietario}")
	public String ver(@PathVariable(value = "codigo_propietario") int codigo_propietario, Map<String, Object> model, RedirectAttributes flash) {
		Propietario propietario = service.findOne(codigo_propietario);
		if(propietario==null) {
			flash.addFlashAttribute("error","El personal no existe en la base de datos");
			return "redirect:/listar";
		}
		model.put("propietario",propietario);
		model.put("titulo","Detalle del propietario:"+propietario.getNombre_Propietario());		
		
		return "ver";
	}
	
	
	@GetMapping("/listar")	
	@RequestMapping(value="/listar",method=RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page,5);
		
		 Page<Propietario> propietarios= service.findAll(pageRequest);
		 
		 PageRender<Propietario> pageRender = new PageRender<>("/listar",propietarios);
		 model.addAttribute("titulo", "Listado de Personal");
		 model.addAttribute("propietarios", propietarios);
		 model.addAttribute("page", pageRender);
		return "index";
	}
	@GetMapping("/editar/{codigo_propietario}")
	public String editar(@PathVariable int codigo_propietario, Model model) {
		Optional<Propietario> propietario=service.listarId(codigo_propietario);
		model.addAttribute("Propietario", propietario);

		return "form";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("Propietario", new Propietario());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Propietario p, Model model,@RequestParam("file") MultipartFile foto, RedirectAttributes flash) {
		if(!foto.isEmpty()) {
			Path directorRecursos= Paths.get("src//main//resources//static/uploads");
			String rootPath = directorRecursos.toFile().getAbsolutePath();
			try {
				byte [] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta,bytes);
				flash.addFlashAttribute("info","Ha subido correctamente '"+ foto.getOriginalFilename()+ "'");
				p.setFoto(foto.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.save(p);
		flash.addFlashAttribute("success", "Personal Agregado con Exito");
		return "redirect:/listar";		
	}
	
	
	@GetMapping("/eliminar/{codigo_propietario}")
	public String delete(Model model, @PathVariable int codigo_propietario) {
		service.delete(codigo_propietario);
		
		return "redirect:/listar";
	}





}