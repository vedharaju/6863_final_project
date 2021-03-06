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
	private boolean bAdjective = false;
	private int strength = 0;
	private int multiplier = 1;
	
	public void WordSentiment(){
		
	}
	public WordSentiment(String token, String tag) {
		this.token = token;
		this.tag = tag;
		bSentiment = false;
	}

	public WordSentiment(String token, String tag, boolean bAdjective, int strength, int multiplier) {
		this.token = token;
		this.tag = tag;
		this.bSentiment = true;
		this.bAdjective = bAdjective;
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
	
	public boolean isSentiment() {
		return bSentiment;
	}
	
	public boolean isAdjective() {
		return bAdjective;
	}
	
	public int getSentimentIndex() {
		int sentiment = this.strength * this.multiplier;
//		System.out.println("sentiment: " + sentiment);
		if (sentiment == 0) {
			return -12;
		}
		if (sentiment > 0) {
			//its positive
			if (sentiment >= 2) 
				return 1;
			else 
				return 0;
		} else {
			//its negative
			if (sentiment <= -2) 
				return 3;
			else 
				return 2;
		}
	}
	
	public String toString(){
		String retVal = "Token=" + this.token + ", Tag=" + this.tag + ", isSentiment=" + this.bSentiment + 
				", isAdjective=" + this.bAdjective + ", strength=" + this.strength + ", multiplier=" + this.multiplier;
		return retVal;
	}
	
}
