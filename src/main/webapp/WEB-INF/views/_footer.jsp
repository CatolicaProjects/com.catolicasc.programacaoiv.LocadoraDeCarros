
<input type="hidden" id="operacao" value="${operacao}" />

</div>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/dist/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/dist/js/bootstrap-datepicker.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/dist/js/jquery.mask.min.js"></script>

<script>
	function remover_onClick(id) {
		$('#modal_' + id).modal('show');
	}

	$(function() {

		$("#message-positive").hide();
		$("#message-negative").hide();

		$('#menu li').on('click', function() {

			$("li").each(function() {
				$(this).removeClass();
			});

			$(this).addClass("active");
		});

		if ($("#operacao").val() == "1") {
			$("#message-positive").show();
		} else if ($("#operacao").val() == "0") {
			$("#message-negative").show();
		}
		$("#operacao").val("-1");
	});
</script>
</body>
</html>
