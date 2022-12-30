<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Salones</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre del Salón</th>
					<th>Usuarios</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${salones}" var="salon">
					<tr>
						<td>${salon.name}</td>
						<td>
							<ul>
								<c:forEach items="${salon.usuarios}" var="usuario">
									<li>${usuario.first_name}</li>
								</c:forEach>
							</ul>
						</td>
						<td>
							<a href="/salones/${salon.id}" class="btn btn-warning">Ver</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dashboard" class="btn btn-primary">Regresar a Dashboard</a>
		<h2>Salones JOIN</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre de la Clase</th>
					<th>Usuario</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${salones_join}" var="objeto">
					<tr>
						<td>${objeto[0].name}</td>
						<td>${objeto[1].first_name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>