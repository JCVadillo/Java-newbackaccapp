package bankaccapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class CSV {
	
	/*
	 * Method to read from a CSV file
	 * the accounts to be created and 
	 * return as a list
	 * */
	static public List<String[]> read(String file) {
		List<String[]> data = new LinkedList<>();
		String dataRow;
		
		try(BufferedReader br = new BufferedReader (new FileReader(file))) {
			
			while((dataRow = br.readLine()) != null) {
			String [] dataRecord = dataRow.split(",");
			data.add(dataRecord);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
//			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("File could not be readed");
//			e1.printStackTrace();
		}	
		return data;
	}

	
	
}
