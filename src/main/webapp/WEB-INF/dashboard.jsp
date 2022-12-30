<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ <c:out value="${nombre}" /> !</h1>
			<a href="/new" class="btn btn-primary">Agrega Usuario</a>
			<a href="/direcciones/new" class="btn btn-info">Agrega Dirección</a>
			<a href="/salones" class="btn btn-warning">Ver Salones</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>E-mail</th>
					<th>Dirección</th>
					<th>Salón</th>
					<th>Hobbies</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td> <c:out value="${usuario.getFirst_name()}" /> </td>
						<td> <c:out value="${usuario.getLast_name()}" /> </td>
						<td> <c:out value="${usuario.getEmail()}" /> </td>
						<td> ${usuario.direccion.getStreet()} </td>
						<td> ${usuario.salon.getName()}</td>
						<td>
							<ul>
								<c:forEach items="${usuario.hobbies}" var="hobby">
									<li>${hobby.name}</li>
								</c:forEach>
							</ul>
						</td>
						<td>
							<!--  PENDIENTE editar buttons -->
							<form action="/delete/${usuario.getId()}" method="post">
								<input type="hidden" name="_method" value="DELETE" />
								<input type="submit" value="Eliminar" class="btn btn-danger" />
							</form>
							<a href="/edit/${usuario.getId()}" class="btn btn-warning">Editar</a>
							<a href="/asignar/${usuario.id}" class="btn btn-primary">Asignar Hobbies</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>