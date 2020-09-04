<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

</head>
<body>
<ul class = "navbar-nav" id = "list">
		<li class = "nav-item"><a class = "nav-link" href="index">New Search</a></li>
		<li class = "nav-item"><a class = "nav-link" href="bucketList">Check Bucket List</a></li>
	</ul>
	<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Event Link<th>More Info</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="events" items="${events}">
				<tr>
					<td>${events.name}</td>
					<td><a class="btn btn-secondary" href="${events.url}">Check out TicketMaster</a></td>
					<td><a class="btn btn-secondary" href="/detailResults?id=${events.id}">See more Details</a></td>
					<td><a class="btn btn-secondary" href="/addBucket?id=${events.id}">Add To Bucket List</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>