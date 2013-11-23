<%@ include file="../_header.jsp"%>
<h2>Index</h2>

<p>
	<a href="${pageContext.request.contextPath}/categoria/create">Novo</a>
</p>
<table>
	<tr>
		<th></th>
		<th>Nome</th>
		<th></th>
	</tr>

	<c:forEach items="${categorias}" var="categoria">
		<tr>
			<td><a href="${pageContext.request.contextPath}/categoria/edit?id=${categoria.getId()}">${categoria.getId()}</a></td>
			<td>${categoria.getNome()}</td>
			<td><a href="${pageContext.request.contextPath}/categoria/delete?id=${categoria.getId()}">Remover</a>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>