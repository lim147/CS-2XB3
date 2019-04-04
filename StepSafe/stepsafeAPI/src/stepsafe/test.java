package stepsafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import types.*;

public class test {	
	public static ArrayList<Path> generatePaths(String s, String t) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(
				"python py_scripts/hello_world.py " + s.replace(" ", "+") + " " + t.replace(" ", "+"));
		p.waitFor();
		
		ArrayList<Path> result = new ArrayList();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			String line;
			String[] holder;
			while ((line = br.readLine()) != null) {
				if (line.equals("new path")) {
					temp.add("0");
					pathCount++;
				}
				else {
					holder = line.split("");
					temp.add(holder[0]);
					temp.add(holder[1]);
				}
			}
		}		
		
		
		return result;

	}
	

	public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList<ArrayList<Double>> values = path("Scotiabank Arena, 40 Bay St, Toronto", "33 Dundurn St S, Hamilton");
		System.out.println(values);
	}
	

}
