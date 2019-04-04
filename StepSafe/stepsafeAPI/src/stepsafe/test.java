package stepsafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test {	
	public static ArrayList <String> temp = new ArrayList();

	public static void main(String[] args) throws IOException, InterruptedException {                                            
	      Process p = Runtime.getRuntime().exec("python py_scripts\\hello_world.py Scotiabank+Arena,+40+Bay+St,+Toronto 33+Dundurn+St+S,+Hamilton");    
	      p.waitFor();                                                                                                             

	      try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {                                
	          String line;  
	          String[] holder;
	          while ((line = br.readLine()) != null)  {                                                                            
	        	 holder = line.split(" ");
	        	 temp.add(holder[1].replace(",", "")); 
	        	 temp.add(holder[3].replace("}", "")); 
	          }                                                                                                                    
	      }   
	  	
	      double[] values = new double[temp.size()];

	      for (int i = 0; i < temp.size(); i++) {
//			System.out.println(temp.get(i));
			values[i] = Double.valueOf(temp.get(i));
		}
	      
	      for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
		
	}
	

	

}
