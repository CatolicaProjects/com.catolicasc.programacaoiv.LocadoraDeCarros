package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.model.Categoria;
import com.catolicasc.programacaoiv.dao.CategoriaDao;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private CategoriaDao categoriaDao = new CategoriaDao();

	private Integer isSuccess = -1;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("categoria index");
		List<Categoria> categorias = categoriaDao.all();
		model.addAttribute("categorias", categorias);
		
		model.addAttribute("operacao", isSuccess);
		this.isSuccess = -1;
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

		if (categoriaDao.add(categoria)) {
			this.isSuccess = 1;
		} else {
			this.isSuccess = 0;
		}
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		logger.info("categoria edit {}", id);
		Categoria categoria = categoriaDao.find(Long.parseLong(id));
		model.addAttribute("categoria", categoria);
		return "categoria/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Categoria categoria) {
		logger.info("categoria edit {}", categoria.getId());

		if (categoriaDao.edit(categoria)) {
			this.isSuccess = 1;
		} else {
			this.isSuccess = 0;
		}
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		logger.info("categoria delete {}", id);
		Categoria categoria = categoriaDao.find(Long.parseLong(id));

		if (categoriaDao.delete(categoria)) {
			this.isSuccess = 1;
		} else {
			this.isSuccess = 0;
		}
		return "redirect:";
	}
}