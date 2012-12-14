package edu.mit.nlp;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.aliasi.tag.Tagging;

import edu.mit.nlp.WordSentiment;

public class Main {

	public static boolean isAdjective(String pos) {
		if (pos.toLowerCase().startsWith("jj")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isAdverb(String pos) {
		if (pos.toLowerCase().startsWith("rb")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isQuantifier(String word, String pos) {
		if (pos.toLowerCase().startsWith("rb")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isNegation(String word, String pos) {
		if (pos.toLowerCase().startsWith("rb")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException,
	IOException {
		
		Tagging<String> tagged_words = 
				RunMedPost.getWords("Movie has a very good ending");
		System.out.println(tagged_words);
		
		//Create WordSentiment objects
		ArrayList<WordSentiment> alSentiment = new ArrayList();
		//TODO - separate positive, strong positive, negative and strong negative words
		FileReader positive = new FileReader("./positive");
		FileReader negative = new FileReader("./negative_words");
		Categorizer categorizer = new Categorizer(positive, negative);

		
		for (int i = 0; i < tagged_words.size(); ++i) {
			//is it an adjective or an adverb
			String word = tagged_words.token(i);
			String pos = tagged_words.tag(i);
			if (isAdjective(pos) || isAdverb(pos)) {

				int strength=0, multiplier = 0;
				//Check strength, direction
				if (categorizer.isPositive(word)) {
					strength = 1;
				} else if  (categorizer.isNegative(word)) {
					strength = -1;
				}

				//Check vicinity for negation or quantifiers
				if ( i > 0 && strength != 0 && isQuantifier(tagged_words.token(i-1), tagged_words.tag(i-1))) {
					multiplier = 2; 
				} else if ( i > 0 && strength != 0 && isNegation(tagged_words.token(i-1), tagged_words.tag(i-1))) {
					multiplier = -1;
				}

				WordSentiment wordSentiment = new WordSentiment(word, pos, strength, multiplier);				
				alSentiment.add(wordSentiment);
				
			} else {
				//Add to the WordSentiment Arraylist just to captrue the word and its POS
				WordSentiment wordSentiment = new WordSentiment(word, pos);				
				alSentiment.add(wordSentiment);
			}
		}
		
		//TODO: Analyze the WordSentiment Arraylist
		
		

		/*	
		if (acceptable_tags.contains(tagging.tag(i))) {
				filtered_words.put(tagging.token(i), tagging.tag(i));
			}
		
		
		//Get synsets for words that are not found in our dictionary
		
		
		//get the POS tagger to analyze it further
		
		//calculate overall rating
		
		ArrayList<String> words = new ArrayList<String>();
		for ( String k : words_to_categorize.keySet()) {
			String pos = words_to_categorize.get(k);
			if (isAdjective(pos) || isAdverb(pos)) 
				words.add(k);
		}
		FileReader pos = new FileReader("./positive");
		FileReader neg = new FileReader("./negative_words");
		Categorizer categorizer = new Categorizer(pos, neg);
		System.out.println(categorizer.findPolarity(words));
		*/
	}
}
