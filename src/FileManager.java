import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	
	private String filename;
	Scanner myReader;
	
	public FileManager(String filename) {
		this.filename = filename;
	}
	
	public void readAndChooseWord() {
		try {
		    File myFile = new File(this.filename);
		    myReader = new Scanner(myFile);
		    
		    if (myFile.exists()) {
		        System.out.println("File name: " + myFile.getName());
		    } else {
		        System.out.println("The file does not exist.");
		    }
		    
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	System.out.println(data);
		    }
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist !");
		    e.printStackTrace();
		} finally {
			myReader.close();
		}
	}
	
	public void writeNewWordToFile(String newWord) {
		
	}
	
}
