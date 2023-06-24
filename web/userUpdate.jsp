<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configure Account</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Account</h2>
		<s:form action="updateUserAction" class="formTable">
			<s:textfield name="user_name" label="User Name" class="formTextField"/>
			<s:textfield name="password" label="Password" class="formTextField"/>
			<s:submit value="Update" class="actionBtn"/>
		</s:form>
	</div>

</body>
</html>
