<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Exercise</title>
<link rel="stylesheet" href="css/style-welcome.css">
	<pippo:head />
</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Update Exercise Info</h2>
		<s:form action="updateExerciseAction" class="formTable">
			<s:textfield name="burned_calories" label="Calories Burned (cal)" class="formTextField"/>
			<s:textfield name="amount_time" label="Amount of time of exercise (min)" class="formTextField"/>
			<s:textfield name="date" label="Date of Measurement" class="formTextField">
				<s:param name="type">date</s:param>
				<s:param name="displayFormat">dd-MMM-yyyy</s:param>
			</s:textfield>
			<s:submit value="Update Exercise Info" class="actionBtn"/>
		</s:form>
	</div>

</body>
</html>
