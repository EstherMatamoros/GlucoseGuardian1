<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Glucose Measurement</title>
<link rel="stylesheet" href="css/style.css">
	<pippo:head />
</head>
<body>

<%--	<%@ include file="header.jsp" %>--%>

	<div align="center">
		<h2>Add Glucose Measurement</h2>
		<s:form action="glucoseAddAction" class="formTable">
			<s:textfield name="measurement" label="Measurement (mg/dl)" class="formTextField"/>
<%--			<pippo:datetimepicker name="createdDate" label="Date of Measurement" displayFormat="dd-MMM-yyyy"/>--%>
<%--			<input type="date" name="createdDate" label="Date of Measurement" class="formTextField"/>--%>
			<s:textfield name="createdDate" label="Date of Measurement" class="formTextField">
				<s:param name="type">date</s:param>
				<s:param name="displayFormat">dd-MMM-yyyy</s:param>
			</s:textfield>
			<s:submit value="Add Measurement" class="actionBtn"/>
		</s:form>
	</div>

</body>
</html>
