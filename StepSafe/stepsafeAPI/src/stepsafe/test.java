package stepsafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test {	
	public static ArrayList<ArrayList<Double>> path(String s, String t) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(
				"python py_scripts\\hello_world.py " + s.replace(" ", "+") + " " + t.replace(" ", "+"));
		p.waitFor();
		
		int pathCount = 0;
		ArrayList<String> temp = new ArrayList();
		
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
					temp.add(holder[1].replace(",", ""));
					temp.add(holder[3].replace("}", ""));
				}
			}
		}		
		
		ArrayList<ArrayList<Double>> paths = new ArrayList<>();
		paths.add(new ArrayList<>());
		int zeroCount = 0;
		for (int i = 0; i < temp.size(); i++) {
			if (Double.valueOf(temp.get(i)) == 0) {
				paths.add(new ArrayList<>());
				zeroCount++;
			}
			else {
				paths.get(zeroCount).add(Double.valueOf(temp.get(i)));
			}
		}
		paths.remove(paths.size()-1);
		return paths;

	}
	

	public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList<ArrayList<Double>> values = path("Scotiabank Arena, 40 Bay St, Toronto", "33 Dundurn St S, Hamilton");
		System.out.println(values);
	}
	

}
