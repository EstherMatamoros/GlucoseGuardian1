<%--
  Created by IntelliJ IDEA.
  User: esthe
  Date: 04/06/2023
  Time: 05:00 p. m.
  To change this template use File | Settings | File Templates.
--%>
<!-- glucosePage.jsp -->
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
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <div id="addFormSection">
        <!-- Add form code goes here -->
        <jsp:include page="glucoseAdd.jsp" />
    </div>
    <div id="infoTableSection">
        <!-- Information table code goes here -->
        <jsp:include page="glucoseManagement.jsp" />
    </div>
</div>
</body>
</html>