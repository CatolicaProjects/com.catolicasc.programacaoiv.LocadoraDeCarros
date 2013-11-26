<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="create" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${carro.getId()}">

		<div class="editor-label">
			<label>Nome</label>
		</div>
		<div class="editor-field">
			<input type="text" name="nome" class="form-control"
				placeholder="Nome">
		</div>

		<div class="editor-label">
			<label>Placa</label>
		</div>
		<div class="editor-field">
			<input type="text" name="placa" class="form-control"
				placeholder="Placa">
		</div>

		<div class="editor-label">
			<label>Ano</label>
		</div>
		<div class="editor-field">
			<input type="text" name="ano" class="form-control" placeholder="Ano">
		</div>

		<div class="editor-label">
			<label>Categoria</label>
		</div>
		<select class="form-control" name="idCategoria">
			<c:forEach items="${categorias}" var="categoria">
				<option value="${categoria.getId()}">${categoria.getNome()}</option>
			</c:forEach>
		</select>

		<p>
			<button type="submit" class="btn btn-primary">Criar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>