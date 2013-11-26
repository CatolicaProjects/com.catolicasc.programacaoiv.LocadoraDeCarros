<%@ include file="../_header.jsp"%>
<h2>Index</h2>

<p>
	<a href="${pageContext.request.contextPath}/precolocacao/create">Novo</a>
</p>
<table>
	<tr>
		<th></th>
		<th>Preço</th>
		<th></th>
	</tr>

	<c:forEach items="${precoLocacoes}" var="precoLocacao">
		<tr>
			<td><a href="${pageContext.request.contextPath}/precolocacao/edit?id=${precoLocacao.getId()}">${precoLocacao.getId()}</a></td>
			<td>${precoLocacao.getPreco()}</td>
			<td><a href="${pageContext.request.contextPath}/precolocacao/delete?id=${precoLocacao.getId()}">Remover</a>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>