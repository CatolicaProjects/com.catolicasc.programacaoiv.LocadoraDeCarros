<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="edit" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${carro.getId()}">

		<div class="editor-label">
			<label>Nome</label>
		</div>
		<div class="editor-field">
			<input type="text" name="nome" value="${carro.getNome()}"
				class="form-control" placeholder="Nome">
		</div>

		<div class="editor-label">
			<label>Placa</label>
		</div>
		<div class="editor-field">
			<input type="text" name="placa" value="${carro.getPlaca()}" id="placa"
				class="form-control" placeholder="Placa">
		</div>

		<div class="editor-label">
			<label>Ano</label>
		</div>
		<div class="editor-field">
			<input type="text" name="ano" value="${carro.getAno()}" id="ano"
				class="form-control" placeholder="Ano">
		</div>

		<div class="editor-label">
			<label>Categoria</label>
		</div>
		<select class="form-control" name="idCategoria">
			<c:forEach items="${categorias}" var="categoria">
				<c:choose>
					<c:when test="${categoria eq categoriaSelecionada}">
						<option value="${categoria.getId()}" selected>${categoria.getNome()}</option>
					</c:when>
					<c:otherwise>
						<option value="${categoria.getId()}">${categoria.getNome()}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>

		<p>
			<button type="submit" class="btn btn-primary">Editar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/carro/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>
<%@ include file="carro.js"%>