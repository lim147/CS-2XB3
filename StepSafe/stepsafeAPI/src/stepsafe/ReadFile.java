package stepsafe;

/**
 *  The {@code ReadFile} class reads from the dataset file
 *  //apply fuhttps://marketplace.eclipse.org/content/eclipse-java-ee-developer-tools-0nction to load data to dbase:
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import notused.CrmALst;
import types.Event;
import types.Point2D;

public class ReadFile {
	public static void read_from_db(List<Event> dbase) throws NumberFormatException, IOException {
		
		//read from database
		File f = new File("/Users/mc/Desktop/CS_2XB3/2XB3_Project/StepSafe/stepsafeAPI/Dataset/MCI_2014_to_2017.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int count = 0;
		double deg = 0;
		while ((line = br.readLine()) != null) {
			if (count == 0){
				count++;
				continue;
			}
			String[] temp = line.split(",");
			
			if (temp[8].equals("Assault"))
				deg = 1;
			else if (temp[8].equals("Break and Enter")) 
				deg = 2;
			else if (temp[8].equals("Robbery"))
				deg = 3;
			else if (temp[8].equals("Theft Over"))
				deg = 2;
			else if (temp[8].equals("Auto Theft"))
				deg = 1;
			else
				throw new IllegalArgumentException("MCI not matched");
				
			Event e = new Event(temp[0], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[7]), temp[8], new Point2D(Double.parseDouble(temp[12]), Double.parseDouble(temp[13])),deg);
			dbase.add(e);
			count++;
		}
		fr.close();
	}
}
