<%@ include file="../_header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Create</h2>

<form action="edit" method="post">
	<fieldset>
		<legend>Nome</legend>

		<input type="hidden" name="id" value="${locacao.getId()}">

		<div class="editor-label">
			<label>Preço</label>
		</div>
		<div class="editor-field">
			<input type="text" name="preco" value="${locacao.getPreco()}" class="form-control" placeholder="Preço">
		</div>
		
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
		
		<div class="editor-label">
			<label>Preço Locação</label>
		</div>
		<select class="form-control" name="idCategoria">
			<c:forEach items="${precoLocacoes}" var="precoLocacao">
				<c:choose>
					<c:when test="${precoLocacao eq precoLocacaoSelecionada}">
						<option value="${precoLocacao.getId()}" selected>${precoLocacao.getId()}</option>
					</c:when>
					<c:otherwise>
						<option value="${precoLocacao.getId()}">${precoLocacao.getId()}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		<div class="editor-label">
			<label>Carro</label>
		</div>
		<select class="form-control" name="idCarro">
			<c:forEach items="${carros}" var="carro">
				<c:choose>
					<c:when test="${carro eq carroSelecionada}">
						<option value="${carro.getId()}" selected>${carro.getNome()}</option>
					</c:when>
					<c:otherwise>
						<option value="${carro.getId()}">${carro.getNome()}</option>
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
	<a href="${pageContext.request.contextPath}/">Voltar</a>
</div>
<%@ include file="../_footer.jsp"%>