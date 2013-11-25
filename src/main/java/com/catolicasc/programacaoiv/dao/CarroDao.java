package com.catolicasc.programacaoiv.dao;

import com.catolicasc.programacaoiv.model.Carro;
import com.catolicasc.programacaoiv.repository.Repository;
import java.util.List;

public class CarroDao {

	public void add(Carro carro) {
		Long id = this.incrementId();
		carro.setId(id);
		Repository.getInstance().carros.add(carro);
	}

	public void delete(Carro carro) {
		Repository.getInstance().carros.remove(carro);
	}

	public void edit(Carro carro) {
		Carro c = this.find(carro.getId());
		Integer index = Repository.getInstance().carros.indexOf(c);
		Carro oldC = Repository.getInstance().carros.get(index);
		this.delete(oldC);
		this.add(carro);
	}

	public Carro find(Long id) {
		for (Carro carro : Repository.getInstance().carros) {
			if (carro.getId().equals(id)) {
				return carro;
			}
		}
		return null;
	}

	public List<Carro> all() {
		return Repository.getInstance().carros;
	}

	private Long incrementId() {
		Long id = (long) 1;
		Integer index = Repository.getInstance().carros.size() - 1;

		if (!Repository.getInstance().carros.isEmpty()) {
			id = Repository.getInstance().carros.get(index).getId() + 1;
		}

		return id;
	}
}
