<%--
  Created by IntelliJ IDEA.
  User: esthe
  Date: 30/05/2023
  Time: 04:35 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Glucose Guardian</title>
    <link rel="stylesheet" href="css/loginregister.css">

    <script type="text/javascript">
        function slide() {
            var slider = document.getElementById("slider");
            slider.classList.toggle("moveslider");

            var formSection = document.getElementById("form-section");
            formSection.classList.toggle("form-section-move");
        }
    </script>

</head>
<body>
<header>
    <h1 class="heading">Glucose Guardian</h1>
    <h3 class="title">Login & Registration Form</h3>
</header>

<div class="container">
    <div class="slider" id="slider"></div>
    <div class="btn">
        <button class="login" onclick="slide()">Login</button>
        <button class="signup" onclick="slide()">Signup</button>
    </div>

    <div class="form-section" id="form-section">
        <div class="login-box">
            <s:form action="loginAction" class="login-box">
                <s:textfield name="userName" label="User Name" class="name ele" />
                <s:password name="password" label="Password" class="password ele"/>
                <s:submit value="Login" class="clkbtn" />
            </s:form>
        </div>

        <div class="signup-box">
            <s:form action="usersAddAction" class="signup-box">
                <s:textfield name="user_name" label="User Name" class="name ele"/>
                <s:textfield name="password" label="Password" class="password ele"/>
                <s:submit value="Register" class="clkbtn"/>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>
