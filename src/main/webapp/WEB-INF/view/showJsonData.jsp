<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
<%JSONArray jsonarray=(JSONArray)request.getAttribute("jsonarray"); %>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">userId</th>
      <th scope="col">id</th>
      <th scope="col">title</th>
      <th scope="col">body</th>
    </tr>
  </thead>
  <tbody>

<%
for (Object object : jsonarray) {
	JSONObject jsonObject=(JSONObject)object;
%>
	<tr>
      <td><%=jsonObject.get("userId") %></td>
      <td><%=jsonObject.get("id") %></td>
      <td><%=jsonObject.get("title") %></td>
      <td><%=jsonObject.get("body") %></td>
    </tr>

<%}%>
	
  </tbody>
</table>
	
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
