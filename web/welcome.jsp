<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="css/style-welcome.css">
	<%@ include file="header.jsp" %>
	<style>
		h1, p {
			color: dodgerblue;
		}
	</style>

</head>
<body>
<div class="row">
	<div class="column1">
		<h1>Glucose Guardian</h1>
		<p>Keep track of your health with us!</p>
		<a href="glucoseAdd.jsp"><button class="actionBtn">Add Glucose Measurement</button></a>
		<a href="dietAdd.jsp"><button class="actionBtn">Add Meal</button></a>
		<a href="medicationAdd.jsp"><button class="actionBtn">Track your Meds</button></a>

	</div>
	<div class="column2">
		<img src="images/welcome.jpg" alt="banner" width="700px">
	</div>

</div>

</body>
</html>
