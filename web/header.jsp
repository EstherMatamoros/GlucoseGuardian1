<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <style>
        /* CSS styles for the subnavigation bar */
        .navbar {
            overflow: hidden;
            background-color: dodgerblue;
        }

        /* Navigation links */
        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* The subnavigation menu */
        .subnav {
            float: left;
            overflow: hidden;
        }

        /* Subnav button */
        .subnav .subnavbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }

        /* Add a red background color to navigation links on hover */
        .navbar a:hover, .subnav:hover .subnavbtn {
            background-color: dodgerblue;
        }

        /* Style the subnav content - positioned absolute */
        .subnav-content {
            display: none;
            position: absolute;
            left: 0;
            background-color: dodgerblue;
            width: 100%;
            z-index: 1;
        }

        /* Style the subnav links */
        .subnav-content a {
            float: left;
            color: white;
            text-decoration: none;
        }

        /* Add a grey background color on hover */
        .subnav-content a:hover {
            background-color: dodgerblue;
            color: dodgerblue;
        }

        /* When you move the mouse over the subnav container, open the subnav content */
        .subnav:hover .subnav-content {
            display: block;
        }
    </style>

</head>
<body>
<%
    if(session.getAttribute("loggedinUser") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!-- Load font awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- The navigation menu -->
<div class="navbar">
    <div class="subnav">
        <button class="subnavbtn">Add Information <i class="fa fa-caret-down"></i></button>
        <div class="subnav-content">
            <a href="glucoseAdd.jsp">Add Glucose</a>
            <a href="dietAdd.jsp">Add Meals</a>
            <a href="exerciseAdd.jsp">Add Exercise</a>
            <a href="medicationAdd.jsp">Add Medication</a>
            <a href="appointmentAdd.jsp">Add Appointment</a>

        </div>
    </div>

    <div class="subnav">
        <button class="subnavbtn">See Logs <i class="fa fa-caret-down"></i></button>
        <div class="subnav-content">
            <a href="glucoseManagementAction">Glucose Track</a>
            <a href="dietManagementAction">Meals</a>
            <a href="exerciseManagementAction">Exercise</a>
            <a href="medicationManagementAction">Medications</a>
            <a href="appointmentManagementAction">Appointments</a>

        </div>
    </div>

    <a href="userUpdate.jsp" style="float:right">Account</a>

    <a href="logoutAction" style="float:right">Logout</a>
</div>

</body>
</html>