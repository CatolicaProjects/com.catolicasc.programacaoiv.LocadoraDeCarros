<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="create" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${locacao.getId()}">

		<div class="editor-label">
			<label>Preço</label>
		</div>
		<div class="editor-field">
			<input type="text" name="preco" class="form-control" placeholder="Preço">
		</div>
		
		<div class="editor-label">
			<label>Tipo Kilometragem</label>
		</div>
		<select class="form-control" name="tpkm">
			<option value="1">KM LIVRE</option>
			<option value="2">KM PERCORRIDO</option>
		</select>
		
		<div class="editor-label">
			<label>Preço Locação</label>
		</div>
		<select class="form-control" name="idPrecoLocacao">
			<c:forEach items="${precoLocacoes}" var="precoLocacao">
				<option value="${precoLocacao.getId()}">${precoLocacao.getId()}</option>
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

		<p>
			<button type="submit" class="btn btn-primary">Criar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>