package App;

import java.time.Duration;
import java.time.Instant;

public class Timer {

	Instant start = Instant.now();
	
	public Timer() {}
	
	public void displayTime() {
	    Instant end = Instant.now();
	    Duration timeElapsed = Duration.between(start, end);
	    System.out.println("Vous avez trouvé en : "+ timeElapsed.toSeconds() +" secondes");
	}
	
}
