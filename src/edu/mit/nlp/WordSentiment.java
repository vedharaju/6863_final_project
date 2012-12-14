package edu.mit.nlp;

public class WordSentiment {
	/*
	 * Create a new Class to hold token, tag, positive or negative (+2, +1, -1, -2), preceded by negation or quantifier (sign or multiplier)
	 * Summary -
	 * strong pos >= +2
	 * pos =1 
	 * strong neg <= -2
	 * neg = -1
	 * 
	 * Two options:
	 * sum up all the four to get one number or treat them separately
	 * 
	 * 
	 */
	private String token;
	private String tag;
	private boolean bSentiment = false;
	private int strength = 0;
	private int multiplier = 1;
	
	public void WordSentiment(){
		
	}
	public WordSentiment(String token, String tag) {
		this.token = token;
		this.tag = tag;
		bSentiment = false;
	}

	public WordSentiment(String token, String tag, int strength, int multiplier) {
		this.token = token;
		this.tag = tag;
		this.bSentiment = true;
		this.strength = strength;
		this.multiplier = multiplier;
	}
	
	public int getWordSentimentScore(){
		if (this.bSentiment) {
			return strength * multiplier;
		} else {
			return 0;
		}
	}
	
	
	
}
