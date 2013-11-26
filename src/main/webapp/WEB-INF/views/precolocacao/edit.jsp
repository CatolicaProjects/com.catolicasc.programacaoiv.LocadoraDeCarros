<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="edit" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${precoLocacao.getId()}">

		<div class="editor-label">
			<label>Preço</label>
		</div>
		<div class="editor-field">
			<input type="text" name="preco" value="${precoLocacao.getPreco()}" class="form-control" placeholder="Preço">
		</div>
		
		<p>
			<button type="submit" class="btn btn-primary">Editar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>