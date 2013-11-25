package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.Cliente;
import com.catolicasc.programacaoiv.repository.Repository;

public class ClienteDao {
	public void add(Cliente c) {
		Long id = this.incrementId();
		c.setId(id);
		Repository.getInstance().clientes.add(c);
	}

	public void delete(Cliente c) {
		Repository.getInstance().clientes.remove(c);
	}

	public void edit(Cliente c) {
		Cliente x = this.find(c.getId());
		Integer index = Repository.getInstance().clientes.indexOf(x);
		Cliente oldX = Repository.getInstance().clientes.get(index);
		this.delete(oldX);
		this.add(c);
	}

	public Cliente find(Long id) {
		for (Cliente c : Repository.getInstance().clientes) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public List<Cliente> all() {
		return Repository.getInstance().clientes;
	}

	private Long incrementId() {
		Long id = (long) 1;
		Integer index = Repository.getInstance().clientes.size() - 1;

		if (!Repository.getInstance().clientes.isEmpty()) {
			id = Repository.getInstance().clientes.get(index).getId() + 1;
		}

		return id;
	}
}
