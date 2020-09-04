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
	<div class="container">

		<div class="jumbotron">
			<h2 class="display-3 light">TicketMaster Events</h2>
		</div>

		<form class="form-inline" action="/cityResults">
			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Enter a City</label> 
				<select name= "city">
				<!-- <input type="text" name="city" placeholder=city >-->
				<option value= "Detroit" name="city">Detroit</option>
				<option value= "Chicago" name="city">Chicago</option>
				<option value= "Philadelphia" name="city">Philadelphia</option>
				<option value= "New York City" name="city">New York City</option>
				<option value= "Cleveland" name="city">Cleveland</Cleveland>
				<option value= "Miami" name="city">Miami</option>
				<option value= "Toronto" name="city">Toronto</option>
				<option value= "Houston" name="city">Houston</option>
				<option value= "Las Vegas" name="city">Las Vegas</option>
				<option value= "Atlanta" name="city">Atlanta</option>
				<option value= "Phoenix" name="city">Phoenix</Cleveland>
				<option value= "Orlando" name="city">Orlando</option>
				<option value= "Grand Rapids" name="city">Grand Rapids</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary mb-2">Find the event</button>
		</form>
		<form class="form-inline" action="/dateResults">
			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Enter a Date</label> 
				<input type="date" name="startDateTime" >
				<input type="date" name="endDateTime" >
			</div>
			<button type="submit" class="btn btn-primary mb-2">Find the event</button>
		</form>
		<form class="form-inline" action="/keywordResults">
			<div class="form-group mx-sm-3 mb-2">
				<label class="sr-only">Enter a Keyword</label> 
				<input type="text" name="keyword" placeholder=keyword >
			</div>
			<button type="submit" class="btn btn-primary mb-2">Find the event</button>
		</form>

	</div>
<body>

</body>
</html>