package com.catolicasc.programacaoiv.controller;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.model.Cliente;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private List<Cliente> _clientes = new ArrayList<Cliente>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("cliente index");

		model.addAttribute("clientes", _clientes);

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

		Long id = (long) 1;
		Integer index = _clientes.size() - 1;

		if (!_clientes.isEmpty()) {
			id = _clientes.get(index).getId() + 1;
		}

		cliente.setId(id);
		_clientes.add(cliente);

		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {

		logger.info("cliente edit {}", id);

		Cliente cliente = find(id);
		model.addAttribute("cliente", cliente);

		return "cliente/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Cliente cliente) {

		logger.info("cliente edit {}", cliente.getId());

		Cliente clienteARemover = find(cliente.getId().toString());
		_clientes.remove(clienteARemover);
		_clientes.add(cliente);

		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {

		logger.info("cliente delete {}", id);

		Cliente cliente = find(id);
		_clientes.remove(cliente);

		return "redirect:";
	}

	@SuppressWarnings("unused")
	private Cliente find(String id) {
		for (Cliente cliente : _clientes) {
			if (cliente.getId().equals(Long.parseLong(id))) {
				logger.info(cliente.getNome());
				return cliente;
			}
		}
		return null;
	}

}
