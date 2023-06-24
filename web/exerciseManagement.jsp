<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exercise Manager</title>
<link rel="stylesheet" href="css/style.css">
<pippo:head />
</head>
<body>
	
	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Exercise Management</h2>
		<s:if test="exerciseInfos !=null && !exerciseInfos.isEmpty()">
			<s:form id="exerciseForm" action="exerciseManagementAction" class="filterPanel">
				<s:textfield name="burned_calories" label="Calories Burned (cal)" class="formTextField"/>
				<s:textfield name="amount_time" label="Duration of exercise (min)" class="formTextField"/>
				<pippo:datetimepicker name="date" label="Date" displayFormat="dd-MMM-yyyy" />
				<s:submit value="Search Exercise" class="actionBtn"/>
			</s:form>
		</s:if>
	</div>

	<s:if test="exerciseInfos !=null && !exerciseInfos.isEmpty()">

		<table width="750" class="productTable" align="center">
			<thead>
				<tr>
					<th>Calories Burned (Cal)</th>
					<th>Duration of exercise (min)</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="exerciseInfos" var="exerciseInfo">
				<tr>
					<td>
						<s:property value="#exerciseInfo.burned_calories"/>
					</td>
					<td>
						<s:property value="#exerciseInfo.amount_time"/>
					</td>
					<td>
						<s:property value="#exerciseInfo.date"/>
					</td>
					<td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
	</s:if>


	<script>
		// JavaScript/jQuery code
		$(document).ready(function() {
			var user_id = <%= (Integer) session.getAttribute("loggedInUserId") %>; // Retrieve the user_id from the session
			var actionUrl = "exerciseManagementAction?user_id=" + user_id;
			$("#exerciseForm").attr("action", actionUrl);
		});
	</script>
</body>
</html>
