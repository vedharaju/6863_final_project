import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
	IOException {
		
		ArrayList<String> words_to_categorize = 
				RunMedPost.getWords("Hiii how are you so pretty?");
		FileReader pos = new FileReader("./positive");
		FileReader neg = new FileReader("./negative_words");
		Categorizer categorizer = new Categorizer(pos, neg);
		System.out.println(categorizer.findPolarity(words_to_categorize));
	}
}
