<%@ include file="../_header.jsp"%>
<h2>Index</h2>

<p>
	<a href="${pageContext.request.contextPath}/cliente/create">Novo</a>
</p>
<table>
	<tr>
		<th></th>
		<th>Nome</th>
		<th>CPF</th>
		<th>Endereço</th>
		<th></th>
	</tr>

	<c:forEach items="${clientes}" var="cliente">
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/cliente/edit?id=${cliente.getId()}">${cliente.getId()}</a></td>
			<td>${cliente.getNome()}</td>
			<td>${cliente.getCpf()}</td>
			<td>${cliente.getEndereco()}</td>
			<td><a
				href="${pageContext.request.contextPath}/cliente/delete?id=${cliente.getId()}">Remover</a>
		</tr>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>