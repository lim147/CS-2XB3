<%@page import="stepsafe.Client.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="types.*"%>
<%@ page import="stepsafe.*"%>
<%@ page import="stepsafe.ReadFile"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>

<!DOCTYPE html>
<html>
<body>
	
	<%
			String s = request.getParameter("start");
				String t = request.getParameter("end");
				out.print("Start: "  + s + "<br/>");
				out.print("End: "  + t + "<br/>");
		%>


	<%
		//out.print("<br/>" + "The path options are:" + "<br/>" + "<br/>");
			
			ArrayList<Path> pathlist = stepsafe.Client.generatePaths(s, t);
			
			//for(int i = 1; i <= pathlist.size(); i++){		
			//	out.print("<br/>");			
			//	out.print("Path ");			
			//	out.print(i);			
			//	out.print("<br/>");			
			//	out.println(pathlist.get(i-1).toWeb());			
			//}
	%>
	
	
	
	<%
					out.print("<br/>" + "The optimal path is: " + "<br/>" + "<br/>");
					
					ArrayList<Event> dbase = new ArrayList<Event>(); //create a CrmALst instance:
					ReadFile.read_from_db(dbase);
					

					
					//Path optPath = new Path();
					Path optPath = stepsafe.Client.optimalPath(pathlist, dbase);
					out.println(optPath.toWeb());
					
					/* for(int i = 0; i < result.size(); i++){
						out.print(result.get(i).toWeb() + "<br/>");	
					}  */
				%>
	
	
	



</body>
</html>