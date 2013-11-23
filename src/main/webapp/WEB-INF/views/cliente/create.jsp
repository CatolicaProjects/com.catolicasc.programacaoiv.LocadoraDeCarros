<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="create" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${cliente.getId()}">

		<div class="editor-label">
			<label>Nome</label>
		</div>
		<div class="editor-field">
			<input type="text" name="nome" class="form-control" placeholder="Nome">
		</div>

		<div class="editor-label">
			<label>CPF</label>
		</div>
		<div class="editor-field">
			<input type="text" name="cpf" class="form-control" placeholder="CPF">
		</div>
		
		<div class="editor-label">
			<label>Endereço</label>
		</div>
		<div class="editor-field">
			<input type="text" name="endereco" class="form-control" placeholder="Endereço">
		</div>

		<p>
			<button type="submit" class="btn btn-primary">Criar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>