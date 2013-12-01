<%@ include file="../_header.jsp"%>
<h2>Todos os carros</h2>

<p>
	<a class="btn btn-success"
		href="${pageContext.request.contextPath}/carro/create">Novo</a>
</p>
<table class="table table-bordered">
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
			<td><a
				href="${pageContext.request.contextPath}/carro/edit?id=${carro.getId()}">${carro.getId()}</a></td>
			<td>${carro.getNome()}</td>
			<td>${carro.getPlaca()}</td>
			<td>${carro.getAno()}</td>
			<td>${carro.getCategoria().getNome()}</td>
			<td><button type="button" onClick="remover_onClick(${carro.getId()})"
					class="btn btn-danger btn-xs">Remover</button></td>

			<div class="modal fade" id="modal_${carro.getId()}" tabindex="-1" role="dialog"
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
								href="${pageContext.request.contextPath}/carro/">Voltar</a> <a
								class="btn btn-danger"
								href="${pageContext.request.contextPath}/carro/delete?id=${carro.getId()}">Remover</a>
						</div>
					</div>
				</div>
			</div>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>