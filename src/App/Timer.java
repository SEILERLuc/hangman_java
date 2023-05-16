package App;

import java.time.Duration;
import java.time.Instant;

/**
 *Classe Timer: chronomètre la partie en court, à partir du moment
 *où le mot aléatoire est choisi 
 */
public class Timer {

	Instant start = Instant.now();
	
	public Timer() {}
	
	/**
	 * displayTime: affiche le temps que l'on a mis à trouver le mot
	 * en faisant la différence entre le temps final et initial
	 */
	public void displayTime() {
	    Instant end = Instant.now();
	    Duration timeElapsed = Duration.between(start, end);
	    System.out.println("Vous avez trouvé en : "+ timeElapsed.toSeconds() +" secondes");
	}
	
}
