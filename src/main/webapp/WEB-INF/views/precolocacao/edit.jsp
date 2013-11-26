<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<input type="text" name="preco" value="${precoLocacao.getPreco()}"
				class="form-control" placeholder="Preço">
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

		<div class="editor-label">
			<label>Tipo Kilometragem</label>
		</div>
		<select class="form-control" name="tpkm">
			<c:choose>
				<c:when test="${precoLocacao.getTpkm() eq 1}">
					<option value="1" selected>KM LIVRE</option>
					<option value="2">KM PERCORRIDO</option>
				</c:when>
				<c:otherwise>
					<option value="1">KM LIVRE</option>
					<option value="2" selected>KM PERCORRIDO</option>
				</c:otherwise>
			</c:choose>
		</select>

		<p>
			<button type="submit" class="btn btn-primary">Editar</button>
		</p>
	</fieldset>
</form>

<div>
	<a href="${pageContext.request.contextPath}/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>