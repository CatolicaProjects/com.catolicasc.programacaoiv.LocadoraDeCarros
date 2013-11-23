package com.catolicasc.programacaoiv.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.model.Categoria;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private List<Categoria> _categorias = new ArrayList<Categoria>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("categoria index");

		model.addAttribute("categorias", _categorias);

		return "categoria/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		logger.info("categoria create");

		return "categoria/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Categoria categoria) {
		logger.info(categoria.getNome());

		Long id = (long) 1;
		Integer index = _categorias.size() - 1;

		if (!_categorias.isEmpty()) {
			id = _categorias.get(index).getId() + 1;
		}

		categoria.setId(id);
		_categorias.add(categoria);

		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {

		logger.info("categoria edit {}", id);

		Categoria categoria = find(id);
		model.addAttribute("categoria", categoria);

		return "categoria/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Categoria categoria) {

		logger.info("categoria edit {}", categoria.getId());

		Categoria categoriaARemover = find(categoria.getId().toString());
		_categorias.remove(categoriaARemover);
		_categorias.add(categoria);

		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {

		logger.info("categoria delete {}", id);

		Categoria categoria = find(id);
		_categorias.remove(categoria);

		return "redirect:";
	}

	@SuppressWarnings("unused")
	private Categoria find(String id) {
		for (Categoria categoria : _categorias) {
			if (categoria.getId().equals(Long.parseLong(id))) {
				logger.info(categoria.getNome());
				return categoria;
			}
		}
		return null;
	}

}
