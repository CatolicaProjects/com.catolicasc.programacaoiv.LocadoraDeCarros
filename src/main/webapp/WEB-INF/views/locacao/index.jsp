<%@ include file="../_header.jsp"%>
<h2>Index</h2>

<p>
	<a href="${pageContext.request.contextPath}/locacao/create">Novo</a>
</p>
<table>
	<tr>
		<th></th>
		<th>Data de Loca��o</th>
		<th>Pre�o Loca��o</th>
		<th>Carro</th>
		<th>Cliente</th>
		<th></th>
	</tr>

	<c:forEach items="${locacoes}" var="locacao">
		<tr>
			<td><a href="${pageContext.request.contextPath}/locacao/edit?id=${locacao.getId()}">${locacao.getId()}</a></td>
			<td>${locacao.getDataLocacaoFormatada()}</td>
			<td>${locacao.getPrecoLocacao().getId()}</td>
			<td>${locacao.getCarro().getNome()}</td>
			<td>${locacao.getCliente().getNome()}</td>
			<td><a href="${pageContext.request.contextPath}/locacao/delete?id=${locacao.getId()}">Remover</a>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>