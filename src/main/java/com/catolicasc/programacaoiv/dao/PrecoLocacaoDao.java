package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.PrecoLocacao;
import com.catolicasc.programacaoiv.repository.Repository;

public class PrecoLocacaoDao {
	public void add(PrecoLocacao c) {
		Long id = this.incrementId();
		c.setId(id);
		Repository.getInstance().precoLocacoes.add(c);
	}

	public void delete(PrecoLocacao c) {
		Repository.getInstance().precoLocacoes.remove(c);
	}

	public void edit(PrecoLocacao c) {
		PrecoLocacao x = this.find(c.getId());
		Integer index = Repository.getInstance().precoLocacoes.indexOf(x);
		PrecoLocacao oldX = Repository.getInstance().precoLocacoes.get(index);
		this.delete(oldX);
		this.add(c);
	}

	public PrecoLocacao find(Long id) {
		for (PrecoLocacao c : Repository.getInstance().precoLocacoes) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public List<PrecoLocacao> all() {
		return Repository.getInstance().precoLocacoes;
	}

	private Long incrementId() {
		Long id = (long) 1;
		Integer index = Repository.getInstance().precoLocacoes.size() - 1;

		if (!Repository.getInstance().precoLocacoes.isEmpty()) {
			id = Repository.getInstance().precoLocacoes.get(index).getId() + 1;
		}

		return id;
	}
}
