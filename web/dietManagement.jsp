<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Diet Manager</title>
<link rel="stylesheet" href="css/style.css">
<pippo:head />
</head>
<body>
	
	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Diet Management</h2>
		<s:if test="dietInfos != null && !dietInfos.isEmpty()">
			<s:form action="dietManagementAction" class="filterPanel">
				<s:textfield name="meal" label="Meal Name" class="formTextField"/>
				<s:textfield name="carbs" label="Number of Carbs" class="formTextField"/>
				<pippo:datetimepicker name="datetime" label="Set Time" displayFormat="HH:mm:ss" />
				<s:submit value="Search Diet" class="actionBtn"/>
			</s:form>
		</s:if>
	</div>

	<s:if test="dietInfos != null && !dietInfos.isEmpty()">
		<table width="750" class="productTable" align="center">
			<thead>
			<tr>
				<th>Meal</th>
				<th>Carbs</th>
				<th>Time</th>
				<th colspan="2">Actions</th>

			</tr>
			</thead>

			<tbody>
			<s:iterator value="dietInfos" var="dietInfo">
				<tr>
					<td>
						<s:property value="#dietInfo.meal"/>
					</td>
					<td>
						<s:property value="#dietInfo.carbs"/>
					</td>
					<td>
						<s:property value="#dietInfo.datetime"/>
					</td>
					<td>
						<a href="updateDietDataAction?diet_id=<s:property value="#dietInfo.diet_id"/>&meal=<s:property value="#dietInfo.meal"/>&user_id=<s:property value="#dietInfo.user_id"/>&carbs=<s:property value="#dietInfo.carbs"/>&datetime=<s:property value="#dietInfo.datetime"/>">
							<button class="actionBtn">Update</button>
						</a>
					</td>
					<td>
						<a href="deleteDietAction?diet_id=<s:property value="#dietInfo.diet_id"/>">
							<button class="actionBtn">Delete</button>
						</a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
	</s:if>
	<script>
		// JavaScript/jQuery code
		$(document).ready(function() {
			var user_id = <%= (Integer) session.getAttribute("loggedInUserId") %>; // Retrieve the user_id from the session
			var actionUrl = "dietManagementAction?user_id=" + user_id;
			$("#dietForm").attr("action", actionUrl);
		});
	</script>
</body>
</html>
