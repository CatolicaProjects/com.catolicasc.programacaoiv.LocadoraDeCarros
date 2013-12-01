package com.catolicasc.programacaoiv.dao;

import com.catolicasc.programacaoiv.model.Carro;
import com.catolicasc.programacaoiv.repository.Repository;
import java.util.List;

public class CarroDao {

	public boolean add(Carro carro) {
		try {
			Long id = this.incrementId();
			carro.setId(id);
			Repository.getInstance().carros.add(carro);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Carro carro) {
		try {
			Repository.getInstance().carros.remove(carro);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean edit(Carro carro) {
		try {
			Carro c = this.find(carro.getId());
			Integer index = Repository.getInstance().carros.indexOf(c);
			Carro oldC = Repository.getInstance().carros.get(index);
			this.delete(oldC);
			this.add(carro);
			return true;
		} catch (Exception e) {
			return false;
		}
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
