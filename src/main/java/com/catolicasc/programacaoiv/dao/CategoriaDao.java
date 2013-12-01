package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.Categoria;
import com.catolicasc.programacaoiv.repository.Repository;

public class CategoriaDao {

	public boolean add(Categoria c) {
		try {
			Long id = this.incrementId();
			c.setId(id);
			Repository.getInstance().categorias.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Categoria c) {
		try {
			Repository.getInstance().categorias.remove(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean edit(Categoria c) {
		try {
			Categoria x = this.find(c.getId());
			Integer index = Repository.getInstance().categorias.indexOf(x);
			Categoria oldX = Repository.getInstance().categorias.get(index);
			this.delete(oldX);
			this.add(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Categoria find(Long id) {
		for (Categoria c : Repository.getInstance().categorias) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public List<Categoria> all() {
		return Repository.getInstance().categorias;
	}

	private Long incrementId() {
		Long id = (long) 1;
		Integer index = Repository.getInstance().categorias.size() - 1;

		if (!Repository.getInstance().categorias.isEmpty()) {
			id = Repository.getInstance().categorias.get(index).getId() + 1;
		}

		return id;
	}
}
