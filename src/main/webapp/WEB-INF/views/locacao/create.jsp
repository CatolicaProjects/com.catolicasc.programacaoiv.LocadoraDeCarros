<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>Novo</h2>

<form action="create" method="post">
	<fieldset>
		<legend>Nova locação:</legend>

		<input type="hidden" name="id" value="${locacao.getId()}">

		<div class="editor-label">
			<label>Data de Locação</label>
		</div>
		<div class="editor-field">
			<input type="text" class="span2" value="27/11/2013" id="dp1"
				name="dataLocacao">
		</div>

		<div class="editor-label">
			<label>Preço Locação</label>
		</div>
		<select class="form-control" name="idPrecoLocacao">
			<c:forEach items="${precoLocacoes}" var="precoLocacao">
				<option value="${precoLocacao.getId()}">${precoLocacao.toString()}</option>
			</c:forEach>
		</select>

		<div class="editor-label">
			<label>Carro</label>
		</div>
		<select class="form-control" name="idCarro">
			<c:forEach items="${carros}" var="carro">
				<option value="${carro.getId()}">${carro.getNome()}</option>
			</c:forEach>
		</select>

		<div class="editor-label">
			<label>Cliente</label>
		</div>
		<select class="form-control" name="idCliente">
			<c:forEach items="${clientes}" var="cliente">
				<option value="${cliente.getId()}">${cliente.getNome()}</option>
			</c:forEach>
		</select>

		<p>
			<button type="submit" class="btn btn-success">Criar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/locacao/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>
<%@ include file="locacao.js"%>