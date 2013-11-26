package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.*;
import com.catolicasc.programacaoiv.model.*;

@Controller
@RequestMapping(value = "/carro")
public class CarroController {

	private CarroDao carroDao = new CarroDao();
	private CategoriaDao categoriaDao = new CategoriaDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Carro> carros = carroDao.all();
		model.addAttribute("carros", carros);
		return "carro/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		List<Categoria> categorias = categoriaDao.all();
		model.addAttribute("categorias", categorias);
		return "carro/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Carro carro) {
		Categoria categoria = categoriaDao.find(carro.getIdCategoria());
		carro.setCategoria(categoria);
		
		carroDao.add(carro);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		List<Categoria> categorias = categoriaDao.all();
		model.addAttribute("categorias", categorias);
		
		Carro carro = carroDao.find(Long.parseLong(id));
		model.addAttribute("carro", carro);
		
		Categoria categoriaSelecionada = categoriaDao.find(carro.getIdCategoria());
		model.addAttribute("categoriaSelecionada", categoriaSelecionada);
		return "carro/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Carro carro) {
		Categoria categoria = categoriaDao.find(carro.getIdCategoria());
		carro.setCategoria(categoria);
		
		carroDao.edit(carro);
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		Carro carro = carroDao.find(Long.parseLong(id));
		carroDao.delete(carro);
		return "redirect:";
	}
}