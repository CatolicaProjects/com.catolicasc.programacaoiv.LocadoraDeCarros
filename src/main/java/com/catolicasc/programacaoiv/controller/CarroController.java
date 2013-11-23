package com.catolicasc.programacaoiv.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.model.Carro;

@Controller
@RequestMapping(value = "/carro")
public class CarroController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private List<Carro> _carros = new ArrayList<Carro>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("carro index");

		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
		 * locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 * 
		 * 
		 * List<Carro> carros = new ArrayList<Carro>();
		 * 
		 * Carro car1 = new Carro(); car1.setNome("Peugeot");
		 * 
		 * carros.add(car1);
		 */
		model.addAttribute("carros", _carros);

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

		Long id = (long) 1;
		Integer index = _carros.size() - 1;

		if (!_carros.isEmpty()) {
			id = _carros.get(index).getId() + 1;
		}

		carro.setId(id);
		_carros.add(carro);

		return "redirect:";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {

		logger.info("carro edit {}", id);
		
		Carro carro = find(id);
		model.addAttribute("carro", carro);
		
		return "carro/edit";
	}

	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Carro carro) {

		logger.info("carro edit {}", carro.getId());
		
		Carro carroARemover = find(carro.getId().toString());
		_carros.remove(carroARemover);
		_carros.add(carro);
		
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {

		logger.info("carro delete {}", id);
		
		Carro carro = find(id);
		_carros.remove(carro);
		
		return "redirect:";
	}
	
	@SuppressWarnings("unused")
	private Carro find(String id) {
		for (Carro carro : _carros) {
			if (carro.getId().equals(Long.parseLong(id))) {
				logger.info(carro.getNome());
				return carro;
			}
		}
		return null;
	}
	
}
