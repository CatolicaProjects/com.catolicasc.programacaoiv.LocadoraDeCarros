package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.*;
import com.catolicasc.programacaoiv.model.Carro;

@Controller
@RequestMapping(value = "/carro")
public class CarroController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private CarroDao carroDao = new CarroDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("carro index");
		List<Carro> carros = carroDao.all();
		model.addAttribute("carros", carros);
		return "carro/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		logger.info("carro create");
		return "carro/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Carro carro) {
		logger.info(carro.getNome());
		carroDao.add(carro);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		logger.info("carro edit {}", id);
		Carro carro = carroDao.find(Long.parseLong(id));
		model.addAttribute("carro", carro);
		return "carro/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Carro carro) {
		logger.info("carro edit {}", carro.getId());
		carroDao.edit(carro);
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		logger.info("carro delete {}", id);
		Carro carro = carroDao.find(Long.parseLong(id));
		carroDao.delete(carro);
		return "redirect:";
	}
}