package com.catolicasc.programacaoiv.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.catolicasc.programacaoiv.model.*;
import com.catolicasc.programacaoiv.dao.*;

public class Repository {

	private static Repository instance = null;

	protected Repository() {
		carros = new ArrayList<Carro>();
		usuarios = new ArrayList<User>();
		categorias = new ArrayList<Categoria>();
		clientes = new ArrayList<Cliente>();
		locacoes = new ArrayList<Locacao>();
		precoLocacoes = new ArrayList<PrecoLocacao>();
	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
			instance.seed();
		}
		return instance;
	}

	public List<Carro> carros;
	public List<User> usuarios;
	public List<Categoria> categorias;
	public List<Cliente> clientes;
	public List<Locacao> locacoes;
	public List<PrecoLocacao> precoLocacoes;
	
	private void seed(){
		Categoria categoria = new Categoria();
		categoria.setNome("Popular");
		new CategoriaDao().add(categoria);
		
		Carro carro = new Carro();
		carro.setNome("Uno");
		carro.setCategoria(categoria);
		new CarroDao().add(carro);
		
		PrecoLocacao precoLocacao = new PrecoLocacao();
		precoLocacao.setPreco(5.0);
		precoLocacao.setTpkm(2);
		precoLocacao.setCategoria(categoria);
		new PrecoLocacaoDao().add(precoLocacao);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Glauco");
		new ClienteDao().add(cliente);
		
		Locacao locacao = new Locacao();
		locacao.setCarro(carro);
		locacao.setCliente(cliente);
		locacao.setPrecoLocacao(precoLocacao);
		Date date = new Date();
		locacao.setDataLocacao(date);
		new LocacaoDao().add(locacao);
	}

}
