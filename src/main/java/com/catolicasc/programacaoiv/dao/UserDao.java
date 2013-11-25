package com.catolicasc.programacaoiv.dao;

import java.util.List;

import com.catolicasc.programacaoiv.model.User;
import com.catolicasc.programacaoiv.repository.Repository;

public class UserDao {
	public void add(User c) {
		Long id = this.incrementId();
		c.setId(id);
		Repository.getInstance().usuarios.add(c);
	}

	public void delete(User c) {
		Repository.getInstance().usuarios.remove(c);
	}

	public void edit(User c) {
		User x = this.find(c.getId());
		Integer index = Repository.getInstance().usuarios.indexOf(x);
		User oldX = Repository.getInstance().usuarios.get(index);
		this.delete(oldX);
		this.add(c);
	}

	public User find(Long id) {
		for (User c : Repository.getInstance().usuarios) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public List<User> all() {
		return Repository.getInstance().usuarios;
	}

	private Long incrementId() {
		Long id = (long) 1;
		Integer index = Repository.getInstance().usuarios.size() - 1;

		if (!Repository.getInstance().usuarios.isEmpty()) {
			id = Repository.getInstance().usuarios.get(index).getId() + 1;
		}

		return id;
	}
}
