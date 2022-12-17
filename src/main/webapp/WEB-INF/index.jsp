<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyecto Usuarios</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>¡Hola mundo en Spring con Plantillas!</h1>
	<h2>
		<c:out value="${titulo}"/>
	</h2>
	
	<ul>
		<c:forEach var="usuario" items="${usuarios}">
			<li>
				<c:out value="${usuario}" />
				
				<c:if test="${usuario == 'Juana'}">
					;)
				</c:if>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>