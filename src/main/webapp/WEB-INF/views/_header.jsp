<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Locadora de Carros</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/dist/css/starter-template.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/dist/css/datepicker.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Locadora de Carros</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">Locadora
					de Carros</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav" id="menu">
					<li><a href="${pageContext.request.contextPath}/carro/">Carros</a></li>
					<li><a href="${pageContext.request.contextPath}/cliente/">Clientes</a></li>
					<li><a href="${pageContext.request.contextPath}/categoria/">Categorias</a></li>
					<li><a href="${pageContext.request.contextPath}/precolocacao/">Preço
							Locação</a></li>
					<li><a href="${pageContext.request.contextPath}/locacao/">Locação</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">
			
		<div hidden="hidden" id="message-positive"
			class="alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<strong>Sucesso!</strong> Registro salvo.
		</div>

		<div hidden="hidden" id="message-negative"
			class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<strong>Ops!</strong> Houve algum problema!
		</div>