<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pippo" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="css/style-welcome.css">
<%--<pippo:head />--%>
	<%@ include file="header.jsp" %>

</head>
<body>
	

<%--	<div align="center">--%>
<%--		<h2>Welcome</h2>--%>
<%--		<s:form action="welcomeAction" class="filterPanel">--%>
<%--			<s:textfield name="productName" label="Product Name" class="formTextField"/>--%>
<%--			<s:textfield name="productCategory" label="Product Category" class="formTextField"/>--%>
<%--			<pippo:datetimepicker name="createdDate" label="Create Date" displayFormat="dd-MMM-yyyy" />--%>
<%--			<s:submit value="Search Product" class="actionBtn"/>--%>
<%--		</s:form>--%>
<%--	</div>--%>

<%--	<table width="750" class="productTable" align="center">--%>
<%--		<thead>  --%>
<%--			<tr>--%>
<%--				<th>Product ID</th>--%>
<%--				<th>Product Name</th>--%>
<%--				<th>Product Category</th>--%>
<%--				<th>Product Price</th>--%>
<%--				<th>Created Date</th>--%>
<%--				<th colspan="2">Actions</th>--%>
<%--			</tr>--%>
<%--		</thead>--%>
<%--	--%>
<%--		<s:iterator value="products" var="product">--%>
<%--			<tr>--%>
<%--				<td>--%>
<%--					<s:property value="#product.productId"/>--%>
<%--				</td>--%>
<%--				<td>--%>
<%--					<s:property value="#product.productName"/>--%>
<%--				</td>--%>
<%--				<td>--%>
<%--					<s:property value="#product.productCategory"/>--%>
<%--				</td>--%>
<%--				<td>--%>
<%--					<s:property value="#product.productPrice"/>--%>
<%--				</td>--%>
<%--				<td>--%>
<%--					<s:property value="#product.createdDate"/>--%>
<%--				</td>--%>
<%--				<td>--%>
<%--					<a--%>
<%--					href="updateDataAction?productId=<s:property value="#product.productId"/>">--%>
<%--						<button class="actionBtn">Update</button>--%>
<%--					</a>	--%>
<%--				</td>--%>
<%--				<td>--%>
<%--					<a href="deleteAction?productId=<s:property value="#product.productId"/>">--%>
<%--						<button class="actionBtn">Delete</button>--%>
<%--					</a>--%>
<%--				</td>--%>
<%--			</tr>--%>
<%--		</s:iterator>--%>
<%--		--%>
<%--	</table>--%>
<%--<body>--%>
<%--<nav>--%>
<%--	<div class="logo">Brand</div>--%>
<%--	<!-- toggle menu button -->--%>
<%--	<span class="menubtn" onclick="openNav()">&#9776;</span>--%>

<%--	<div class="navLinks">--%>
<%--		<ul>--%>
<%--			<li><a href="#">Home</a></li>--%>
<%--			<li><a href="#">About</a></li>--%>
<%--			<li><a href="#">Services</a></li>--%>
<%--			<li><a href="#">Contact</a></li>--%>
<%--			<button type="button">Login</button>--%>
<%--		</ul>--%>
<%--	</div>--%>
<%--</nav>--%>
<%--<!-- responsive side navbar -->--%>
<%--<div class="sideNav" id="sidenav">--%>
<%--	<a href="#" class="closeBtn" onclick="closeNav()"> &#10006;</a>--%>
<%--	<a href="#">Home</a>--%>
<%--	<a href="#">About</a>--%>
<%--	<a href="#">Services</a>--%>
<%--	<a href="#">Contact</a>--%>
<%--	<a href="#"><button type="button">Login</button> </a>--%>
<%--</div>--%>

<!-- Header content with banner image -->
<div class="row">
	<div class="column1">
		<h1>Glucose Guardian</h1>
		<p>Keep track of your health with us!</p>
<%--		<button href="glucosePage.jsp">Keep track of your glucose</button>--%>
		<a href="glucosePage.jsp"><button type="button">Track your glucose</button> </a>
	</div>
	<div class="column2">
		<img src="images/welcome.jpg" alt="banner" width="700px">
	</div>
</div>

<!-- javascript to make side menu appear -->
<%--<script>--%>
<%--	function openNav() {--%>
<%--		document.getElementById("sidenav").style.width = "50%";--%>
<%--	}--%>
<%--	function closeNav() {--%>
<%--		document.getElementById("sidenav").style.width = "0%";--%>
<%--	}--%>
<%--</script>--%>

<%--</body>--%>
<%--</html>--%>
</body>
</html>
