package com.catolicasc.programacaoiv.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
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

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("carro index");
		
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		
		List<Carro> carros = new ArrayList<Carro>();
		
		Carro car1 = new Carro();
		car1.setNome("Peugeot");
		
		carros.add(car1);
		
		model.addAttribute("carros", carros);
		
		return "carro/index";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		logger.info("carro create");

		return "carro/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model) {
		logger.info("carro create post");
		
		return "redirect:";
	}
}
