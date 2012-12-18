package edu.mit.nlp;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class NaiveBayesTraining {

	public static int getSentiment(Integer[] word_counts) {
//		System.out.println("counts " + Arrays.toString(word_counts));

		// prior prob
		double positive = 0.5;
		double negative = 0.5;

		// counts of words
		int strong_pos_adj = word_counts[1];
		int pos_adj = word_counts[0];
		int strong_pos_adv = word_counts[5];
		int pos_adv = word_counts[4];
		int strong_neg_adj = word_counts[3];
		int neg_adj = word_counts[2];
		int strong_neg_adv = word_counts[7];
		int neg_adv = word_counts[6];

		// test 1: the number of strong positive adjectives is > 2.number of
		// strong negative adjectives
		double test1_pos = 0.81;
		double test1_neg = 0.37;

		// test 2: the number of strong positive adverbs is > 2.number of strong
		// negative adverbs
		double test2_pos = 0.22;
		double test2_neg = 0.18;

//		 test 3: total positive > total negative
		 double test3_pos = 0.88;
		 double test3_neg = 0.65;

		// test 4: the number of strong negative adjectives is >2.number of
		// strong positive adjectives
		double test4_pos = 0.01;
		double test4_neg = 0.13;

		// test 5: the number of strong negative adverbs is >2.number of strong
		// positive adverbs
		 double test5_pos = 0.08;
		 double test5_neg = 0.06;

		// test 6: total negative > total positive
		double test6_pos = 0.11;
		double test6_neg = 0.33;


		boolean test1;
		boolean test2;
		boolean test3;
		boolean test4;
		boolean test5;
		boolean test6;

		// test1
		if (strong_pos_adj > 2 * strong_neg_adj) {
			test1 = true;
		} else {
			test1 = false;
		}

		// test2
		if (strong_pos_adv > 2 * strong_neg_adv) {
			test2 = true;
		} else {
			test2 = false;
		}

		// test3
		if (strong_pos_adj + strong_pos_adv + pos_adj + pos_adv > strong_neg_adj
				+ strong_neg_adv + neg_adj + neg_adv) {
			test3 = true;
		} else {
			test3 = false;
		}

		// test4
		if (strong_neg_adj > 2 * strong_pos_adj) {
			test4 = true;
		} else {
			test4 = false;
		}

		// test5
		if (strong_neg_adv > 2 * strong_pos_adv) {
			test5 = true;
		} else {
			test5 = false;
		}

		// test6
		if (strong_neg_adj + strong_neg_adv + neg_adj + neg_adv > strong_pos_adj
				+ strong_pos_adv + pos_adj + pos_adv) {
			test6 = true;
		} else {
			test6 = false;
		}

		// Boolean[] test_results = { test1, test2, test3, test4, test5, test6
		// };
		// Double[] prob_given_positive = { test1_pos, test2_pos, test3_pos,
		// test4_pos, test5_pos, test6_pos };
		// Double[] prob_given_negative = { test1_neg, test2_neg, test3_neg,
		// test4_neg, test5_neg, test6_neg };

		Boolean[] test_results = { test1, test3, test4, test6 };
//		System.out.println("test results: " + Arrays.toString(test_results));
		Double[] prob_given_positive = { test1_pos, test3_pos, test4_pos, test6_pos };
		Double[] prob_given_negative = { test1_neg, test3_neg, test4_neg, test6_neg };

		// calculating probability of positiveness
//		System.out.println("Calculating positive");
		Double prob_positive = positive;

		for (int i = 0; i < test_results.length; i++) {
			if (test_results[i]) {
				prob_positive = prob_positive * prob_given_positive[i];
//				System.out.println(prob_given_positive[i]);
			} else {
				prob_positive = prob_positive * (1 - prob_given_positive[i]);
//				System.out.println(1 - prob_given_positive[i]);
			}
		}


//		System.out.println("Calculating negative");
		Double prob_negative = negative;
		for (int i = 0; i < test_results.length; i++) {
			if (test_results[i]) {
				prob_negative = prob_negative * prob_given_negative[i];
//				System.out.println(prob_given_negative[i]);
			} else {
				prob_negative = prob_negative * (1 - prob_given_negative[i]);
//				System.out.println(1 - prob_given_negative[i]);
			}
		}

//		System.out.println("positive: " + prob_positive);
//		System.out.println("negative: " + prob_negative);
		int answer;
		if (prob_positive > prob_negative) {
			answer = +1;
		} else if (prob_positive < prob_negative) {
			answer = -1;
		} else {
			answer = 0;
		}

		// System.out.println("The answer is: " + answer);
		return answer;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {

		File dir = new File("./neg");
		int correct = 0;
		int count = 1;
//		File child = new File("./pos/cv626_7410.txt");
		for (File child: dir.listFiles()) {
			System.out.println(count);
			Integer[] word_counts = TrainingCounts.counts(child);
//			System.out.println("word counts: "  + Arrays.toString(word_counts));
			if (getSentiment(word_counts) > 0) {
				correct += 1;
			}
			count++;
		}
		System.out.println("counts: " +  correct);
	}
}
