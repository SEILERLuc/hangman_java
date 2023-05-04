import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	
	private String filename;
	Scanner myReader;
	
	public FileManager(String filename) {
		this.filename = filename;
	}
	
	public void chooseWord() {
		try {
		    File myFile = new File(this.filename);
		    myReader = new Scanner(myFile);
		    
		    if (myFile.exists()) {
		        System.out.println("File name: " + myFile.getName());
		        System.out.println("Absolute path: " + myFile.getAbsolutePath());
		        System.out.println("File size in bytes " + myFile.length());
		    } else {
		        System.out.println("The file does not exist.");
		    }
		    
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	System.out.println(data);
		    }
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		} finally {
			myReader.close();
		}
	}
	
}