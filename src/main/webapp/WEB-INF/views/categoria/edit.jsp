<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="edit" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${categoria.getId()}">

		<div class="editor-label">
			<label>Nome</label>
		</div>
		<div class="editor-field">
			<input type="text" name="nome" value="${categoria.getNome()}" class="form-control" placeholder="Nome">
		</div>
		
		<p>
			<button type="submit" class="btn btn-primary">Editar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/categoria/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>