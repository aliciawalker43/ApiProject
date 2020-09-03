<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

				</tr>
				<tr>
				     <td>${events.info }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>