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
<<<<<<< 
<div class = "navbar navbar-expand">

	<ul class = "navbar-nav" id = "list">
		<li class = "nav-item"><a class = "nav-link" href="index">New Search</a></li>
	</ul>
</div>


<table class="table">
	
			<thead>
				<tr>
					<th>Name</th><th>Info</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bucketList" items="${bucketList}">
				<tr>


					<td>${tables.name}</td>
				    <td>${tables.info }</td>
             </tr>

					<td>${bucketList.name}</td>
				    <td>${bucketList.info }</td>
				    <td><a href="<c:url value="/deleteBucket/${events.tableId}/delete"/>" class="btn btn-dark">Delete</a></td>
				</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>