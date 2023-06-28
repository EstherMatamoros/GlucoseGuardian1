<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New meal</title>
<link rel="stylesheet" href="css/style.css">
	<pippo:head />
</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Add New Meal</h2>
		<s:form action="dietAddAction" class="formTable">
			<s:textfield name="meal" label="Meal" class="formTextField"/>
			<s:textfield name="carbs" label="No. of carbs" class="formTextField"/>
			<pippo:datetimepicker name="datetime" label="Set Time" displayFormat="HH:mm:ss" />
			<s:submit value="Add Diet" class="actionBtn"/>
		</s:form>
	</div>

</body>
</html>
