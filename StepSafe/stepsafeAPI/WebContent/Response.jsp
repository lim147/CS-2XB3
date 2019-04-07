<%@page import="stepsafe.test.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="types.*"%>
<%@ page import="stepsafe.ReadFile*"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>

<!DOCTYPE html>
<html>
<body>
	
	<%
		String s = request.getParameter("start");
		String t = request.getParameter("end");
		out.print("Start:" + "<br/>" + s + "<br/>");
		out.print("End:" + "<br/>" + t + "<br/>");
	%>


	<%
		out.print("<br/>" + "The path options are:" + "<br/>" + "<br/>");
		
		ArrayList<Path> result = stepsafe.test.generatePaths(s, t);
		ArrayList<Event> dbase = new ArrayList<Event>(); //create a CrmALst instance:
		ReadFile.read_from_db(dbase);
		
		
		for(int i = 1; i <= result.size(); i++){		
			out.print("<br/>");			
			out.print("Path ");			
			out.print(i);			
			out.print("<br/>");			
			out.println(result.get(i-1).toWeb());			
		}
		
		

		
		
		
	%>




</body>
</html>