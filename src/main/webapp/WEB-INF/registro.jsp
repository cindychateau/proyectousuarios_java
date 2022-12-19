<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Crear Usuario</h1>
		<form action="/registrar" method="post">
			<div>
				<label>Nombre:</label>
				<input type="text" name="nombre">
			</div>
			<div>
				<label>Email:</label>
				<input type="email" name="email">
			</div>
			<input type="submit" value="Guardar" class="btn btn-success" >
		</form>
		<div class="text-danger">
			<c:out value="${errorNombre}" />
		</div>
	</div>
</body>
</html>