import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class PositiveTrainingSamples {
	
	File file;
	Scanner sc;
	
	HashMap<String, Integer> counts;

	
	PositiveTrainingSamples(File file) {
		this.file = file;
	}
	
	public HashMap<String, Integer> countWords() throws FileNotFoundException {
		String next;
		sc = new Scanner(file);
		while (sc.hasNext()) {
			next = sc.next();
			if (counts.containsKey(next)){
				counts.put(next, counts.get(next) + 1) ;
			}
		}
		return counts;
	}
	
	public HashMap<String, Integer> getCounts(){
		return counts;
	}
}
