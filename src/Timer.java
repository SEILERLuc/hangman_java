import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer {

	private LocalTime beginTime = LocalTime.now();;
	private int timeSec;
	
	public Timer() {}
	
	public String getTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
	    System.out.println("After formatting: " + formattedDate);
	    return formattedDate;
	}
	
	public void setTime() {
		LocalTime myObj = LocalTime.now();
	}
	
}
