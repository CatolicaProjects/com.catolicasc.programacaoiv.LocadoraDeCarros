package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.LocacaoDao;
import com.catolicasc.programacaoiv.model.Locacao;

@Controller
@RequestMapping(value = "/locacao")
public class LocacaoController {

	private LocacaoDao locacaoDao = new LocacaoDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Locacao> locacoes = locacaoDao.all();
		model.addAttribute("locacoes", locacoes);
		return "locacao/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "locacao/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Locacao locacao) {
		locacaoDao.add(locacao);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		Locacao locacao = locacaoDao.find(Long.parseLong(id));
		model.addAttribute("locacao", locacao);
		return "locacao/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Locacao locacao) {
		locacaoDao.edit(locacao);
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		Locacao locacao = locacaoDao.find(Long.parseLong(id));
		locacaoDao.delete(locacao);
		return "redirect:";
	}
}