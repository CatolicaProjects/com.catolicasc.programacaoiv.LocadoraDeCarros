package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.ClienteDao;
import com.catolicasc.programacaoiv.model.Cliente;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private ClienteDao clienteDao = new ClienteDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("cliente index");
		List<Cliente> clientes = clienteDao.all();
		model.addAttribute("clientes", clientes);
		return "cliente/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		logger.info("cliente create");
		return "cliente/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Cliente cliente) {
		logger.info(cliente.getNome());
		clienteDao.add(cliente);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		logger.info("cliente edit {}", id);
		Cliente cliente = clienteDao.find(Long.parseLong(id));
		model.addAttribute("cliente", cliente);
		return "cliente/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Cliente cliente) {
		logger.info("cliente edit {}", cliente.getId());
		clienteDao.edit(cliente);
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		logger.info("cliente delete {}", id);
		Cliente cliente = clienteDao.find(Long.parseLong(id));
		clienteDao.delete(cliente);
		return "redirect:";
	}
}
