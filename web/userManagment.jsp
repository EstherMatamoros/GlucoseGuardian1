<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="css/style.css">
<pippo:head />
</head>
<body>
	
	<%@ include file="header.jsp" %>
	
	<div align="center">
		<h2>Users Management</h2>
		<s:form action="userManagementAction" class="filterPanel">
			<s:textfield name="user_name" label="User Name" class="formTextField"/>
			<s:submit value="Search User" class="actionBtn"/>
		</s:form>
	</div>

	<table width="750" class="productTable" align="center">
		<thead>  
			<tr>
				<th>User Name</th>
				<th>Password</th>
			</tr>
		</thead>
	
		<s:iterator value="Users" var="users">
			<tr>
				<td>
					<s:property value="#users.user_name"/>
				</td>
				<td>
					<s:property value="#users.password"/>
				</td>

			</tr>
		</s:iterator>
		
	</table>
</body>
</html>
