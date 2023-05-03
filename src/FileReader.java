import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	String filename;
	
	public FileReader(String filename) {
		this.filename = filename;
	}
	
	public void chooseWord() {
		try {
		    File myObj = new File(this.filename);
		    Scanner myReader = new Scanner(myObj);
		    
		    if (myObj.exists()) {
		        System.out.println("File name: " + myObj.getName());
		        System.out.println("Absolute path: " + myObj.getAbsolutePath());
		        System.out.println("Writeable: " + myObj.canWrite());
		        System.out.println("Readable " + myObj.canRead());
		        System.out.println("File size in bytes " + myObj.length());
		    } else {
		        System.out.println("The file does not exist.");
		    }
		    
		    while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		    	System.out.println(data);
		    }
		    myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
}
