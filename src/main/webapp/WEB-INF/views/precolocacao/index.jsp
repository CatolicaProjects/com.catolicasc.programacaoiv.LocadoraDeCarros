<%@ include file="../_header.jsp"%>
<h2>Todos os preços das locações</h2>

<p>
	<a class="btn btn-success"
		href="${pageContext.request.contextPath}/precolocacao/create">Novo</a>
</p>
<table class="table table-bordered">
	<tr>
		<th></th>
		<th>Preço</th>
		<th>Categoria</th>
		<th>Tipo Kilometragem</th>
		<th></th>
	</tr>

	<c:forEach items="${precoLocacoes}" var="precoLocacao">
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/precolocacao/edit?id=${precoLocacao.getId()}">${precoLocacao.getId()}</a></td>
			<td>${precoLocacao.getPreco()}</td>
			<td>${precoLocacao.getCategoria().getNome()}</td>
			<td>${precoLocacao.getTipoKilometragem()}</td>
			<td><button type="button" onClick="remover_onClick(${precoLocacao.getId()})"
					class="btn btn-danger btn-xs">Remover</button></td>

			<div class="modal fade" id="modal_${precoLocacao.getId()}" tabindex="-1" role="dialog"
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
								href="${pageContext.request.contextPath}/precolocacao/">Voltar</a>
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/precolocacao/delete?id=${precoLocacao.getId()}">Remover</a>
						</div>
					</div>
				</div>
			</div>
	</c:forEach>
</table>

<%@ include file="../_footer.jsp"%>