package com.catolicasc.programacaoiv.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.*;
import com.catolicasc.programacaoiv.model.*;

@Controller
@RequestMapping(value = "/precolocacao")
public class PrecoLocacaoController {

	/*
	 * private static final Logger logger = LoggerFactory
	 * .getLogger(HomeController.class);
	 */

	private PrecoLocacaoDao precoLocacaoDao = new PrecoLocacaoDao();
	private CategoriaDao categoriaDao = new CategoriaDao();

	private Integer isSuccess = -1;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<PrecoLocacao> precoLocacoes = precoLocacaoDao.all();
		model.addAttribute("precoLocacoes", precoLocacoes);
		
		model.addAttribute("operacao", isSuccess);
		this.isSuccess = -1;
		return "precolocacao/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		List<Categoria> categorias = categoriaDao.all();
		model.addAttribute("categorias", categorias);
		return "precolocacao/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(PrecoLocacao precoLocacao) {
		Categoria categoria = categoriaDao.find(precoLocacao.getIdCategoria());
		precoLocacao.setCategoria(categoria);

		if (precoLocacaoDao.add(precoLocacao)) {
			this.isSuccess = 1;
		} else {
			this.isSuccess = 0;
		}
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		List<Categoria> categorias = categoriaDao.all();
		model.addAttribute("categorias", categorias);

		PrecoLocacao precoLocacao = precoLocacaoDao.find(Long.parseLong(id));
		model.addAttribute("precoLocacao", precoLocacao);

		Categoria categoriaSelecionada = categoriaDao.find(precoLocacao
				.getIdCategoria());
		model.addAttribute("categoriaSelecionada", categoriaSelecionada);

		Integer tpkmSelecionada = precoLocacao.getTpkm();
		model.addAttribute("tpkmSelecionada", tpkmSelecionada);
		return "precolocacao/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(PrecoLocacao precoLocacao) {
		Categoria categoria = categoriaDao.find(precoLocacao.getIdCategoria());
		precoLocacao.setCategoria(categoria);

		if (precoLocacaoDao.edit(precoLocacao)) {
			this.isSuccess = 1;
		} else {
			this.isSuccess = 0;
		}
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		PrecoLocacao precoLocacao = precoLocacaoDao.find(Long.parseLong(id));

		if (precoLocacaoDao.delete(precoLocacao)) {
			this.isSuccess = 1;
		} else {
			this.isSuccess = 0;
		}
		return "redirect:";
	}
}