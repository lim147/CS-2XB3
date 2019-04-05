<%@page import="stepsafe.test"%>
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
		out.println("..."+s + "..." + "...");
	
		ArrayList<String> test = stepsafe.test.join(s, d);
		for(int i = 0; i < test.size(); i++){
			out.println(test.get(i));
		}
	%>




</body>
</html>