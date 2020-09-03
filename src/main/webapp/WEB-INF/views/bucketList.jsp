<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table">
			<thead>
				<tr>
					<th>BUCKLIST</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="events" items="${events}">
				<tr>
					<td>${events.name}</td>
				    <td>${events.url}</td>

<<<<<<< HEAD
				</tr>
				<tr>
				     <td>${events.info }</td>
=======
<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Info</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tables" items="${tables}">
				<tr>
					<td>${tables.name}</td>
				    <td>${tables.info }</td>
>>>>>>> ebe7549951dd09d82adb5869566cd528af7e557b
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<<<<<<< HEAD
=======

>>>>>>> ebe7549951dd09d82adb5869566cd528af7e557b
</body>
</html>