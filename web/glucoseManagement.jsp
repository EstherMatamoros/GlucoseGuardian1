<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Glucose Measurements</title>
	<link rel="stylesheet" href="css/style.css">
	<pippo:head />
	<script>
		// JavaScript code to apply coloring based on glucose measurement
		function applyColoring() {
			const glucoseRows = document.querySelectorAll("table.productTable tbody tr");

			glucoseRows.forEach((row) => {
				const glucoseElement = row.querySelector(".glucose-measurement");
				const measurement = parseInt(glucoseElement.innerText);

				if (measurement < 70) {
					row.style.backgroundColor = "red";
				} else if (measurement > 100) {
					row.style.backgroundColor = "orange";
				} else {
					row.style.backgroundColor = "lightblue";
				}
			});
		}

		// Call the applyColoring function when the page loads
		window.onload = applyColoring;
	</script>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="center">
	<h2>Glucose Management</h2>
	<s:form action="glucoseManagementAction" class="filterPanel">
		<s:textfield name="measurement" label="Measurement (mg/dl)" class="formTextField"/>
		<s:submit value="Search" class="actionBtn"/>
	</s:form>
</div>

<table width="750" class="productTable" align="center">
	<thead>
	<tr>
		<th>Measurement (mg/dl)</th>
		<th>Measurement Date</th>
		<th colspan="2">Actions</th>
	</tr>
	</thead>

	<s:iterator value="glucoses" var="glucose">
		<tr>
			<td class="glucose-measurement">
				<s:property value="#glucose.measurement"/>
			</td>
			<td>
				<s:property value="#glucose.createdDate"/>
			</td>
			<td>
				<a href="updateGlucoseDataAction?id=<s:property value="#glucose.id"/>&timestamp=<s:property value="#glucose.timestamp"/>&user_id=<s:property value="#glucose.user_id"/>&measurement=<s:property value="#glucose.measurement"/>&createdDate=<s:property value="#glucose.createdDate"/>">
					<button class="actionBtn">Update</button>
				</a>
			</td>
			<td>
				<a href="deleteGlucoseAction?timestamp=<s:property value="#glucose.timestamp"/>">
					<button class="actionBtn">Delete</button>
				</a>
			</td>
		</tr>
	</s:iterator>
</table>
</body>
</html>