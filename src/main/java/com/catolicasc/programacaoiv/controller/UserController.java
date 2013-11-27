package com.catolicasc.programacaoiv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.programacaoiv.dao.UserDao;
import com.catolicasc.programacaoiv.model.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private UserDao usuarioDao = new UserDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<User> usuarios = usuarioDao.all();
		model.addAttribute("usuarios", usuarios);
		return "user/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String name, HttpSession session) {
		
		logger.info("nome {}", name);
		/*
		if (user.getName().equals("admin") && user.getPassword().equals("admin")){
			session.setAttribute("usuarioLogado", user);
			return "home";
		}
		return "redirect:login";
		*/
		
		return "home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "user/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(User usuario) {
		usuarioDao.add(usuario);
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String id, Model model) {
		User usuario = usuarioDao.find(Long.parseLong(id));
		model.addAttribute("usuario", usuario);
		return "user/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(User usuario) {
		usuarioDao.edit(usuario);
		return "redirect:";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		User usuario = usuarioDao.find(Long.parseLong(id));
		usuarioDao.delete(usuario);
		return "redirect:";
	}
}