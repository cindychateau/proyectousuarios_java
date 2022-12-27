<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Dirección</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Nueva Dirección</h1>
		<form:form action="/direcciones/create" method="POST" modelAttribute="direccion">
			<div class="form-group">
				<form:label path="street">Calle</form:label>
				<form:input path="street" class="form-control" />
				<form:errors path="street" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="number">Número</form:label>
				<form:input path="number" class="form-control" />
				<form:errors path="number" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="city">Ciudad</form:label>
				<form:input path="city" class="form-control" />
				<form:errors path="city" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="cp">CP</form:label>
				<form:input path="cp" class="form-control" />
				<form:errors path="cp" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="country">País</form:label>
				<form:input path="country" class="form-control" />
				<form:errors path="country" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="usuario">Usuario</form:label>
				<form:select path="usuario" class="form-select">
					<c:forEach items="${usuarios}" var="u">
						<form:option value="${u.id}" >${u.first_name} ${u.last_name}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" value="Guardar" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>