<%@ include file="../_header.jsp"%>
<h2>Todos os clientes</h2>

<p>
	<a class="btn btn-success"
		href="${pageContext.request.contextPath}/cliente/create">Novo</a>
</p>
<table class="table table-bordered">
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
			<td><button type="button" onClick="remover_onClick(${cliente.getId()})"
					class="btn btn-danger btn-xs">Remover</button></td>

			<div class="modal fade" id="modal_${cliente.getId()}" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Remoção de
								registro</h4>
						</div>
						<div class="modal-body">Tem certeza que deseja deletar o
							registro?</div>
						<div class="modal-footer">
							<a class="btn btn-default"
								href="${pageContext.request.contextPath}/cliente/">Voltar</a> <a
								class="btn btn-danger"
								href="${pageContext.request.contextPath}/cliente/delete?id=${cliente.getId()}">Remover</a>
						</div>
					</div>
				</div>
			</div>
		</tr>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>