<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<%
		String s = request.getParameter("start");
		String d = request.getParameter("end");
		
	%>
	
	The input is: 
	
	<% 
		out.println(s + " " + d);
	%>
	
</body>
</html>