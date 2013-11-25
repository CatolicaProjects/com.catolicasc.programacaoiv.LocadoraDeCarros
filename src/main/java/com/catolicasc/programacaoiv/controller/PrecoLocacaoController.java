package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.PrecoLocacaoDao;
import com.catolicasc.programacaoiv.model.PrecoLocacao;

@Controller
@RequestMapping(value = "/precolocacao")
public class PrecoLocacaoController {

	private PrecoLocacaoDao precoLocacaoDao = new PrecoLocacaoDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<PrecoLocacao> precoLocacoes = precoLocacaoDao.all();
		model.addAttribute("precoLocacoes", precoLocacoes);
		return "precolocacao/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "precolocacao/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(PrecoLocacao precoLocacao) {
		precoLocacaoDao.add(precoLocacao);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		PrecoLocacao precoLocacao = precoLocacaoDao.find(Long.parseLong(id));
		model.addAttribute("precoLocacao", precoLocacao);
		return "precolocacao/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(PrecoLocacao precoLocacao) {
		precoLocacaoDao.edit(precoLocacao);
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		PrecoLocacao precoLocacao = precoLocacaoDao.find(Long.parseLong(id));
		precoLocacaoDao.delete(precoLocacao);
		return "redirect:";
	}
}