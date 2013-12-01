<%@ include file="../_header.jsp"%>
<h2>Todas as locações</h2>

<p>
	<a class="btn btn-success" href="${pageContext.request.contextPath}/locacao/create">Novo</a>
</p>
<table class="table table-bordered">
	<tr>
		<th></th>
		<th>Data de Locação</th>
		<th>Preço Locação</th>
		<th>Carro</th>
		<th>Cliente</th>
		<th></th>
	</tr>

	<c:forEach items="${locacoes}" var="locacao">
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/locacao/edit?id=${locacao.getId()}">${locacao.getId()}</a></td>
			<td>${locacao.getDataLocacao()}</td>
			<td>${locacao.getPrecoLocacao().toString()}</td>
			<td>${locacao.getCarro().getNome()}</td>
			<td>${locacao.getCliente().getNome()}</td>
			<td><button type="button" onClick="remover_onClick(${locacao.getId()})"
					class="btn btn-danger btn-xs">Remover</button></td>

			<div class="modal fade" id="modal_${locacao.getId()}" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Remoção de registro</h4>
						</div>
						<div class="modal-body">Tem certeza que deseja deletar o
							registro?</div>
						<div class="modal-footer">
							<a class="btn btn-default"
								href="${pageContext.request.contextPath}/locacao/">Voltar</a> <a
								class="btn btn-danger"
								href="${pageContext.request.contextPath}/locacao/delete?id=${locacao.getId()}">Remover</a>
						</div>
					</div>
				</div>
			</div>
	</c:forEach>

</table>

<%@ include file="../_footer.jsp"%>