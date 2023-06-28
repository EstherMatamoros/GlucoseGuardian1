<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment Manager</title>
<link rel="stylesheet" href="css/style.css">
<pippo:head />
</head>
<body>
	
	<%@ include file="header.jsp" %>

	<div align="center">
		<h2>Appointments Management</h2>
		<s:if test="appointmentsInfos !=null && !appointmentsInfos.isEmpty()">
			<s:form id="appointmentForm" action="appointmentManagementAction" class="filterPanel">
				<s:textfield name="area" label="Medical area" class="formTextField"/>
				<s:textfield name="date" label="Date of Appointment" class="formTextField">
					<s:param name="type">date</s:param>
					<s:param name="displayFormat">dd-MMM-yyyy</s:param>
				</s:textfield>
				<s:textfield name="doctor_name" label="Doctor's name" class="formTextField"/>
				<s:submit value="Search Appointment" class="actionBtn"/>
			</s:form>
		</s:if>
	</div>

	<s:if test="appointmentsInfos !=null && !appointmentsInfos.isEmpty()">

		<table width="750" class="productTable" align="center">
			<thead>
				<tr>
					<th>Medical Area</th>
					<th>Date</th>
					<th>Doctor's name</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="appointmentsInfos" var="appointmentsInfo">
				<tr>
					<td>
						<s:property value="#appointmentsInfo.area"/>
					</td>
					<td>
						<s:property value="#appointmentsInfo.date"/>
					</td>
					<td>
						<s:property value="#appointmentsInfo.doctor_name"/>
					</td>
					<td>
						<a href="updateAppointmentDataAction?appointments_id=<s:property value="#appointmentsInfo.appointments_id"/>&area=<s:property value="#appointmentsInfo.area"/>&user_id=<s:property value="#appointmentsInfo.user_id"/>&amount_time=<s:property value="#appointmentsInfo.date"/>&doctor_name=<s:property value="#appointmentsInfo.doctor_name"/>">
							<button class="actionBtn">Update</button>
						</a>
					</td>
					<td>
						<a href="deleteAppointmentAction?appointments_id=<s:property value="#appointmentsInfo.appointments_id"/>">
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
			var actionUrl = "appointmentManagementAction?user_id=" + user_id;
			$("#appointmentForm").attr("action", actionUrl);
		});
	</script>
</body>
</html>
