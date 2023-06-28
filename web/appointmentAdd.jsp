<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Exercise</title>
<link rel="stylesheet" href="css/style.css">
<%--	<pippo:head />--%>
</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Add Appointment</h2>
		<s:form action="appointmentAddAction" class="formTable">
			<s:textfield name="area" label="Medical area" class="formTextField"/>
			<s:textfield name="date" label="Date of Appointment" class="formTextField">
				<s:param name="type">date</s:param>
				<s:param name="displayFormat">dd-MMM-yyyy</s:param>
			</s:textfield>
			<s:textfield name="doctor_name" label="Doctor's name" class="formTextField"/>
			<s:submit value="Add Appointment" class="actionBtn"/>
		</s:form>
	</div>

</body>
</html>
