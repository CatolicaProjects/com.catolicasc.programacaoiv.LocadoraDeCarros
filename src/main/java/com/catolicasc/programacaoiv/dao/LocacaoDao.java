package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.Locacao;
import com.catolicasc.programacaoiv.repository.Repository;

public class LocacaoDao {
	public boolean add(Locacao c) {
		try {
			Long id = this.incrementId();
			c.setId(id);
			Repository.getInstance().locacoes.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Locacao c) {
		try {
			Repository.getInstance().locacoes.remove(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean edit(Locacao c) {
		try {
			Locacao x = this.find(c.getId());
			Integer index = Repository.getInstance().locacoes.indexOf(x);
			Locacao oldX = Repository.getInstance().locacoes.get(index);
			this.delete(oldX);
			this.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Locacao find(Long id) {
		for (Locacao c : Repository.getInstance().locacoes) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public List<Locacao> all() {
		return Repository.getInstance().locacoes;
	}

	private Long incrementId() {
		Long id = (long) 1;
		Integer index = Repository.getInstance().locacoes.size() - 1;

		if (!Repository.getInstance().locacoes.isEmpty()) {
			id = Repository.getInstance().locacoes.get(index).getId() + 1;
		}

		return id;
	}
}
