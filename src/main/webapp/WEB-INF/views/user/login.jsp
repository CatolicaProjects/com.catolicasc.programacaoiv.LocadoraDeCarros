<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link
	href="${pageContext.request.contextPath}/resources/dist/css/signin.css"
	rel="stylesheet">

<form class="form-signin" action="user/login">
	<h2 class="form-signin-heading">Login</h2>
	<input type="text" class="form-control" name="name" placeholder="Nome" required
		autofocus> <input type="password" class="form-control"
		name="password" placeholder="Senha" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
</form>

<%@ include file="../_footer.jsp"%>