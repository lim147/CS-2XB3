package stepsafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	public static void read_from_db(CrmALst dbase) throws NumberFormatException, IOException {
		
		//read from database
		File f = new File("Data/MCI_2014_to_2017.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int count = 0;
		while ((line = br.readLine()) != null) {
			if (count == 0){
				count++;
				continue;
			}
			String[] temp = line.split(",");
			Event e = new Event(temp[0], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[7]), temp[8], new Point2D(Double.parseDouble(temp[12]), Double.parseDouble(temp[13])));
			dbase.addEvent(e);
			count++;
		}
		fr.close();
	}
	
	
	
	//test:
	public static void main(String[] args) throws NumberFormatException, IOException{
		//create a CrmALst instance:
		CrmALst dbase = new CrmALst();
		//apply function to load data to dbase:
		read_from_db(dbase);
		//dbase.next();
		System.out.println(dbase.current().toString());
		
		
	}
		

}
