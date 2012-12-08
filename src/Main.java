import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;


public class Main {
	public static void main(String [ ] args) throws FileNotFoundException{
		File file =  new File("/Example1");
		PositiveTrainingSamples pos = new PositiveTrainingSamples(file);
		HashMap<String, Integer> counts = pos.countWords();
		System.out.println(counts.toString());
	}
}
