package stepsafe;

/**
 *  The {@code ReadFile} class reads from the dataset file
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

import types.CrmALst;
import types.Event;
import types.Point2D;

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
}
