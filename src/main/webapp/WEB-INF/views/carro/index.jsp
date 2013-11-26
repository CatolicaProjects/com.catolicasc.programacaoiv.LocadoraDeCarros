<%@ include file="../_header.jsp"%>
<h2>Index</h2>

<p>
	<a href="${pageContext.request.contextPath}/carro/create">Novo</a>
</p>
<table>
	<tr>
		<th></th>
		<th>Nome</th>
		<th>Placa</th>
		<th>Ano</th>
		<th>Categoria</th>
		<th></th>
	</tr>

	<c:forEach items="${carros}" var="carro">
		<tr>
			<td><a href="${pageContext.request.contextPath}/carro/edit?id=${carro.getId()}">${carro.getId()}</a></td>
			<td>${carro.getNome()}</td>
			<td>${carro.getPlaca()}</td>
			<td>${carro.getAno()}</td>
			<td>${carro.getCategoria().getNome()}</td>
			<td><a href="${pageContext.request.contextPath}/carro/delete?id=${carro.getId()}">Remover</a>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>