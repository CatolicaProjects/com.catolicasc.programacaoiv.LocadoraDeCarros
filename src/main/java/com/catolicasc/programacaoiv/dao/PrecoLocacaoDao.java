package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.PrecoLocacao;
import com.catolicasc.programacaoiv.repository.Repository;

public class PrecoLocacaoDao {
	public boolean add(PrecoLocacao c) {
		try {
			Long id = this.incrementId();
			c.setId(id);
			Repository.getInstance().precoLocacoes.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(PrecoLocacao c) {
		try {
			Repository.getInstance().precoLocacoes.remove(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean edit(PrecoLocacao c) {
		try {
			PrecoLocacao x = this.find(c.getId());
			Integer index = Repository.getInstance().precoLocacoes.indexOf(x);
			PrecoLocacao oldX = Repository.getInstance().precoLocacoes
					.get(index);
			this.delete(oldX);
			this.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
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
