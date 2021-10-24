package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarView {
	
	int curYear = -1;
	int curMonth = -1;
	int curDay = -1;
	
	public String[][] dateData = new String[6][7];
	
	public CalendarView() {
		
	}
	
	public void loadCurrentMonth() {
		
		curYear =  Calendar.getInstance().get(Calendar.YEAR);
    	System.out.println("Year: " + curYear);
    	curMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
    	System.out.println("Month: " + curMonth);
    	
    	boolean flag = false;
    	
    	File dir = new File("./src/data");
    	
    	Scanner f;

    	File[] matches = dir.listFiles(new FilenameFilter()
    	{
    	  public boolean accept(File dir, String name)
    	  {
    	     return name.startsWith("") && name.endsWith(".txt");
    	  }
    	});
    	for ( File a : matches ) {
    		if ( ( a.getName().substring(0,a.getName().indexOf(".") ) ).equals(String.valueOf(curYear) ) ) {				// If the current file is named (yearLookingFor).txt, then read it
    			System.out.println(a.getName());
    			flag = true;
    			try {
					f = new Scanner(a);																	// Will open the file and start doing shit to it
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	if ( !flag ) {
    		try {
				createFile( String.valueOf(curYear), curYear );
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
	}
	
	public File createFile( String fileName, int year ) throws IOException {
		
		// First it will create the file because it doesn't exist
		File newFile = new File("./src/data/"+fileName+".txt");
		newFile.createNewFile();
		FileWriter myWriter = new FileWriter(newFile);
		myWriter.write("Jan\nFeb\nMar\nApr\nMay\nJun\nJul\nAug\nSep\nOct\nNov\nDec\n");
		myWriter.close();
		
		return newFile;
		
		//Then it will edit the file (which will be used in another function)
		
	}
	
	public void loadData() {
		// First it will clear dateData
		// Then it will load in all of the shits idk
	}
	
}
