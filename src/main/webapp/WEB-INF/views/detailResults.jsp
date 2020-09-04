<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>
<div class = "navbar navbar-expand">

	<ul class = "navbar-nav" id = "list">
		<li class = "nav-item"><a class = "nav-link" href="index">New Search</a></li>
		<li class = "nav-item"><a class = "nav-link" href="bucketList">Check Bucket List</a></li>
		<li class = "nav-item"><a class = "nav-link" href="/"> Return Home</a></li>
	</ul>
</div>
<table class="table">
			<thead>
				<tr>
					<th>Info</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="events" items="${events}">
				<tr>
					<td>${events.info}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
</body>
</html>