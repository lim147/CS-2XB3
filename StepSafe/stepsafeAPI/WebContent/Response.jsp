<%@page import="stepsafe.test.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="types.*" %>

<!DOCTYPE html>
<html>
<body>
	<%
		String s = request.getParameter("start");
		String d = request.getParameter("end");
	%>

	The input is:

	<%
	
		String test = stepsafe.test.printToWeb("Scotiabank Arena, 40 Bay St, Toronto", "Pearson Airport, Mississauga");
		out.println(test);
	%>




</body>
</html>