import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
	IOException {
		
		HashMap<String, String> words_to_categorize = 
				RunMedPost.getWords("Hiii how are you so pretty?");
		ArrayList<String> words = new ArrayList<String>();
		for ( String k : words_to_categorize.keySet()) {
			words.add(k);
		}
		FileReader pos = new FileReader("./positive");
		FileReader neg = new FileReader("./negative_words");
		Categorizer categorizer = new Categorizer(pos, neg);
		System.out.println(categorizer.findPolarity(words));
	}
}
