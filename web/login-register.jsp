<%--
  Created by IntelliJ IDEA.
  User: esthe
  Date: 19/05/2023
  Time: 01:04 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<style>
  body, html {
    height: 100%;
    margin: 0;
  }

  .bgimg {
    background-image: url('images/home.jpg');
    height: 90%;
    background-position: center;
    background-size: cover;
    position: relative;
    color: white;
    font-family: "Courier New", Courier, monospace;
    font-size: 25px;
  }

  .topleft {
    position: absolute;
    top: 0;
    left: 16px;
  }

  .middle {
    position: absolute;
    top: 60%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
  }

  .btn {
    display: inline-block;
    padding: 10px 20px;
    font-size: 20px;
    text-align: center;
    text-decoration: none;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  .btn:hover {
    background-color: #45a049;
  }

  hr {
    margin: auto;
    width: 40%;
  }
</style>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Glucose Guardian</title>
</head>
<body>
<div class="bgimg">
  <div class="topleft">
    <p>Logo</p>
  </div>
  <div class="middle">
    <h2>Welcome to Glucose Guardian</h2>
    <a href="login.jsp" class="btn">Login</a> <!-- Login button -->
    <br><br>
    <a href="userAdd.jsp" class="btn">Registration</a> <!-- Register button -->
  </div>

</div>
</body>
</html>
