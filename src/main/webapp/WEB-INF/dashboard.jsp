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
		<h1>¡Bienvenid@ <c:out value="${nombre}" /> !</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>E-mail</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td> <c:out value="${usuario.getFirst_name()}" /> </td>
						<td> <c:out value="${usuario.getLast_name()}" /> </td>
						<td> <c:out value="${usuario.getEmail()}" /> </td>
						<td>
							<!--  PENDIENTE editar buttons -->
							<form action="/delete/${usuario.getId()}" method="post">
								<input type="hidden" name="_method" value="DELETE" />
								<input type="submit" value="Eliminar" class="btn btn-danger" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>