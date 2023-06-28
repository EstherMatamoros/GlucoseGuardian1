<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medication Management</title>
<link rel="stylesheet" href="css/style.css">
<pippo:head />
</head>
<body>
	
	<%@ include file="header.jsp" %>
	
	<div align="center">
		<h2>Medication Management</h2>
		<s:form action="medicationManagementAction" class="filterPanel">
			<s:textfield name="name" label="Medication Name" class="formTextField"/>
			<s:submit value="Search Medication" class="actionBtn"/>
		</s:form>
	</div>

	<table width="750" class="productTable" align="center">
		<thead>  
			<tr>
				<th>Name</th>
				<th>Dose (mg)</th>
				<th>Treatment for</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
	
		<s:iterator value="medicationInfos" var="medicationInfo">
			<tr>
				<td>
					<s:property value="#medicationInfo.name"/>
				</td>
				<td>
					<s:property value="#medicationInfo.dose"/>
				</td>
				<td>
					<s:property value="#medicationInfo.treatment_for"/>
				</td>
				<td>
					<s:property value="#medicationInfo.date_started"/>
				</td>
				<td>
					<s:property value="#medicationInfo.date_end"/>
				</td>
				<td>
					<a
					href="updateMedicationDataAction?id=<s:property value="#medicationInfo.id"/>&name=<s:property value="#medicationInfo.name"/>&user_id=<s:property value="#medicationInfo.user_id"/>&dose=<s:property value="#medicationInfo.dose"/>&treatment_for=<s:property value="#medicationInfo.treatment_for"/>&date_started=<s:property value="#medicationInfo.date_started"/>&date_end=<s:property value="#medicationInfo.date_end"/>">
						<button class="actionBtn">Update</button>
					</a>
				</td>
				<td>
					<a href="deleteMedicationAction?id=<s:property value="#medicationInfo.id"/>">
						<button class="actionBtn">Delete</button>
					</a>
				</td>
			</tr>
		</s:iterator>
		
	</table>
</body>
</html>
