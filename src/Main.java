import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
	IOException {
		
		HashMap<String, String> words_to_categorize = 
				RunMedPost.getWords("Don't worry: The movie doesn't overplay that aspect. Or, rather, the way it does play to that aspect is both clever and apt. The movie begins, as all Bonds do, with a crackerjack action sequence in which 007 and a comely female operative (Naomie Harris) race through Istanbul in pursuit of a mercenary with a hard drive that's got some highly dangerous classified info on it. It's so highly dangerous that spymaster M (Judi Dench), monitoring the action from London, issues what seems a ruthless direction. It's one that takes Bond out of the picture for a while. As he licks his wounds over his boss's seeming betrayal, things get worse at home. MI6's headquarters is nearly blown sky-high by a terrorizing computer hack of incredible reach and power. The upshot of this disaster is a request for M's resignation from a higher-up bureaucrat played by Ralph Fiennes. Like hell, is the short version of steely M's answer. At which point the presumed-dead Bond returns, a little worse for the wear after his partying sabbatical. M sets him loose despite his shakiness. And so the quest for a villain who knows too much begins.");
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
