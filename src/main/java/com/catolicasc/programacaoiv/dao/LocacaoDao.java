package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.Locacao;
import com.catolicasc.programacaoiv.repository.Repository;

public class LocacaoDao {
	public void add(Locacao c) {
		Long id = this.incrementId();
		c.setId(id);
		Repository.getInstance().locacoes.add(c);
	}

	public void delete(Locacao c) {
		Repository.getInstance().locacoes.remove(c);
	}

	public void edit(Locacao c) {
		Locacao x = this.find(c.getId());
		Integer index = Repository.getInstance().locacoes.indexOf(x);
		Locacao oldX = Repository.getInstance().locacoes.get(index);
		this.delete(oldX);
		this.add(c);
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
