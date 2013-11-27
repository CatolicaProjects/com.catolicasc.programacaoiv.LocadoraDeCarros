package com.catolicasc.programacaoiv.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.*;
import com.catolicasc.programacaoiv.model.*;

@Controller
@RequestMapping(value = "/locacao")
public class LocacaoController {

	private LocacaoDao locacaoDao = new LocacaoDao();
	private PrecoLocacaoDao precoLocacaoDao = new PrecoLocacaoDao();
	private CarroDao carroDao = new CarroDao();
	private ClienteDao clienteDao = new ClienteDao();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Locacao> locacoes = locacaoDao.all();
		model.addAttribute("locacoes", locacoes);
		return "locacao/index";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		List<Cliente> clientes = clienteDao.all();
		model.addAttribute("clientes", clientes);
		
		List<PrecoLocacao> precoLocacoes = precoLocacaoDao.all();
		model.addAttribute("precoLocacoes", precoLocacoes);
		
		List<Carro> carros = carroDao.all();
		model.addAttribute("carros", carros);
		return "locacao/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Locacao locacao) {
		PrecoLocacao precoLocacao = precoLocacaoDao.find(locacao.getIdPrecoLocacao());
		locacao.setPrecoLocacao(precoLocacao);
		
		Cliente cliente = clienteDao.find(locacao.getIdCliente());
		locacao.setCliente(cliente);
		
		Carro carro = carroDao.find(locacao.getIdCarro());
		locacao.setCarro(carro);
		
		locacaoDao.add(locacao);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		Locacao locacao = locacaoDao.find(Long.parseLong(id));
		model.addAttribute("locacao", locacao);
		
		List<PrecoLocacao> precoLocacoes = precoLocacaoDao.all();
		model.addAttribute("precoLocacoes", precoLocacoes);
		
		PrecoLocacao precoLocacaoSelecionada = precoLocacaoDao.find(locacao.getIdPrecoLocacao());
		model.addAttribute("precoLocacaoSelecionada", precoLocacaoSelecionada);
		
		List<Carro> carros = carroDao.all();
		model.addAttribute("carros", carros);
		
		Carro carroSelecionada = carroDao.find(locacao.getIdCarro());
		model.addAttribute("carroSelecionada", carroSelecionada);
		
		List<Cliente> clientes = clienteDao.all();
		model.addAttribute("clientes", clientes);
		
		Cliente clienteSelecionada = clienteDao.find(locacao.getIdCliente());
		model.addAttribute("clienteSelecionada", clienteSelecionada);
		return "locacao/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(Locacao locacao) {
		PrecoLocacao precoLocacao = precoLocacaoDao.find(locacao.getIdPrecoLocacao());
		locacao.setPrecoLocacao(precoLocacao);
		
		Carro carro = carroDao.find(locacao.getIdCarro());
		locacao.setCarro(carro);
		
		Cliente cliente = clienteDao.find(locacao.getIdCliente());
		locacao.setCliente(cliente);
		
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