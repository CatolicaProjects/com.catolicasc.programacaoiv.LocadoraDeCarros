<%@ include file="../_header.jsp"%>
<h2>Todas as categorias</h2>

<p>
	<a class="btn btn-success"
		href="${pageContext.request.contextPath}/categoria/create">Novo</a>
</p>
<table class="table table-bordered">
	<tr>
		<th></th>
		<th>Nome</th>
		<th></th>
	</tr>

	<c:forEach items="${categorias}" var="categoria">
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/categoria/edit?id=${categoria.getId()}">${categoria.getId()}</a></td>
			<td>${categoria.getNome()}</td>
			<td><button type="button" onClick="remover_onClick(${categoria.getId()})"
					class="btn btn-danger btn-xs">Remover</button></td>

			<div class="modal fade" id="modal_${categoria.getId()}" tabindex="-1" role="dialog"
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
								href="${pageContext.request.contextPath}/categoria/">Voltar</a>
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/categoria/delete?id=${categoria.getId()}">Remover</a>
						</div>
					</div>
				</div>
			</div>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>