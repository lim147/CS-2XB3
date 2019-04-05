<%@page import="stepsafe.test.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="types.*"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>

<!DOCTYPE html>
<html>
<body>
	<%
		String s = request.getParameter("start");
		String t = request.getParameter("end");
	%>

	The path options are:

	<%
		Process p = Runtime.getRuntime().exec(
				"python C:\\Users\\robbi\\Desktop\\Classes\\2XB3\\2XB3_Project\\StepSafe\\stepsafeAPI\\py_scripts\\hello_world.py "
						+ s.replace(" ", "+") + " " + t.replace(" ", "+"));
		p.waitFor();

		ArrayList<Path> result = new ArrayList();
		Path route = new Path();

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = br.readLine()) != null) {
			if (line.equals("new path")) {
				result.add(route); //add the route to result list
				route = new Path(); //reinitialize the route
			}

			else {
				String[] holder = line.split(",");
				double x = Double.parseDouble(holder[0]);
				double y = Double.parseDouble(holder[1]);
				String str = holder[2];
				Intersection e = new Intersection(x, y, str); //create new intersection

				route.addIntersection(e);
			}
		}

		result.add(route); //add last route to result list

		for(int i = 0; i < result.size(); i++){		
			out.print("<br/>");			
			out.print("Path ");			
			out.print(i);			
			out.print("<br/>");			
			out.println(result.get(i));			
		}
	%>




</body>
</html>