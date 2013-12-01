<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="create" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${precoLocacao.getId()}">

		<div class="editor-label">
			<label>Preço</label>
		</div>
		<div class="input-group">
			<span class="input-group-addon">$</span> <input type="text" name="preco" id="preco" value="0000" 
				class="form-control"> <span class="input-group-addon">.00</span>
		</div>

		<div class="editor-label">
			<label>Categoria</label>
		</div>
		<select class="form-control" name="idCategoria">
			<c:forEach items="${categorias}" var="categoria">
				<option value="${categoria.getId()}">${categoria.getNome()}</option>
			</c:forEach>
		</select>

		<div class="editor-label">
			<label>Tipo Kilometragem</label>
		</div>
		<select class="form-control" name="tpkm">
			<option value="1">KM LIVRE</option>
			<option value="2">KM PERCORRIDO</option>
		</select>

		<p>
			<button type="submit" class="btn btn-primary">Criar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/precolocacao/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>
<%@ include file="precolocacao.js"%>