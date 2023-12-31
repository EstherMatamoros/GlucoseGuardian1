<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Medication</title>
<link rel="stylesheet" href="css/style.css">
	<pippo:head />
</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Add New Medication</h2>
		<s:form action="medicationAddAction" class="formTable">
			<s:textfield name="name" label="Name of medication" class="formTextField"/>
			<s:textfield name="dose" label="Recommended Dose (mg)" class="formTextField"/>
			<s:textfield name="treatment_for" label="Treatment for" class="formTextField"/>
			<s:textfield name="date_started" label="Treatment started on" class="formTextField">
				<s:param name="type">date</s:param>
				<s:param name="displayFormat">dd-MMM-yyyy</s:param>
			</s:textfield>
			<s:textfield name="date_end" label="Treatment should end on" class="formTextField">
				<s:param name="type">date</s:param>
				<s:param name="displayFormat">dd-MMM-yyyy</s:param>
			</s:textfield>
			<s:submit value="Add Medication" class="actionBtn"/>
		</s:form>
	</div>

</body>
</html>
