package stepsafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import types.*;

public class test {	
	public static ArrayList<Path> generatePaths(String s, String t) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(
				"python py_scripts\\hello_world.py " + s.replace(" ", "+") + " " + t.replace(" ", "+"));
		p.waitFor();
		
		ArrayList<Path> result = new ArrayList();
		Path route  = new Path();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals("new path")) {
					result.add(route); //add the route to result list
					route = new Path(); //reinitialize the route
				}
				
				else {
					String [] holder = line.split(",");
					double x = Double.parseDouble(holder[0]);
					double y = Double.parseDouble(holder[1]);
					String str = holder[2];
					Intersection e = new Intersection(x, y, str); //create new intersection

					route.addIntersection(e);
				}
			}
			
			result.add(route); //add last route to result list
			
		}		
		
		
		return result;

	}
	

	public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList<Path> result = generatePaths("Scotiabank Arena, 40 Bay St, Toronto", "33 Dundurn St S, Hamilton");
		for(int i = 0; i < result.size(); i++) {
			System.out.println("One path is:");
			Path path = result.get(i);
			System.out.print(path.toString());
		}
		
		
	}
	

}