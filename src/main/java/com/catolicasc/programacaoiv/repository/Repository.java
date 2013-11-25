package com.catolicasc.programacaoiv.repository;

import java.util.ArrayList;
import java.util.List;

import com.catolicasc.programacaoiv.model.*;

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
		}
		return instance;
	}

	public List<Carro> carros;
	public List<User> usuarios;
	public List<Categoria> categorias;
	public List<Cliente> clientes;
	public List<Locacao> locacoes;
	public List<PrecoLocacao> precoLocacoes;

}
