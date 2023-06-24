<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Glucose Measurements</title>
	<link rel="stylesheet" href="css/style.css">
	<pippo:head />

	<!-- Include Chart.js library -->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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

<!-- Add the canvas element here -->
<canvas id="lineChart"></canvas>

<table width="750" class="productTable" align="center">
	<thead>
	<tr>
		<th>Measurement (mg/dl)</th>
		<th>Measurement Date</th>
	</tr>
	</thead>

	<s:iterator value="glucoses" var="glucose">
		<tr>
			<td>
				<s:property value="#glucose.measurement"/>
			</td>
			<td>
				<s:property value="#glucose.createdDate"/>
			</td>
		</tr>
	</s:iterator>

</table>

<!-- Line Chart Script -->
<script type="text/javascript">
	// Get the glucose measurements from the server using Struts2 tags
	var glucoses = <s:property value="glucoses"/>;

	// Extract x and y data from the glucose measurements
	var data = glucoses.map(function(glucose) {
		return {
			x: glucose.createdDate,
			y: glucose.measurement
		};
	});

	// Create the line chart
	new Chart(document.getElementById('lineChart'), {
		type: 'line',
		data: {
			datasets: [{
				label: 'Glucose Measurements',
				data: data,
				borderColor: 'blue',
				fill: false
			}]
		},
		options: {
			scales: {
				x: {
					type: 'time',
					time: {
						unit: 'day'
					},
					title: {
						display: true,
						text: 'Measurement Date'
					}
				},
				y: {
					title: {
						display: true,
						text: 'Measurement (mg/dl)'
					}
				}
			}
		}
	});
</script>
</body>
</html>
