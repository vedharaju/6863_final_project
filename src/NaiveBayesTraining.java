import java.util.ArrayList;
import java.util.Arrays;


public class NaiveBayesTraining {
	
	int alpha1 = 0, alpha2 = 0, alpha3 = 0, alpha4 = 0;
	
	public static void main(String[] args) {
		
		//prior prob
		double positive = 0.5;
		double negative = 0.5;
		
		//counts of words
		int strong_adj = 0;
		int adj = 0;
		int strong_adv = 0;
		int adv = 0;
		Integer[] counts = {strong_adj, adj, strong_adv, adv};
		
		//occurrence of strong adjective
		double strong_adjective_1t = 0.0;
		double strong_adjective_2t = 0.0;
		double strong_adjective_3t = 0.0;
		double strong_adjective_4t = 0.0;
		double strong_adjective_5t = 0.0;
		Double[] list1 = {strong_adjective_1t, strong_adjective_2t, strong_adjective_3t, strong_adjective_4t, strong_adjective_5t};
		ArrayList<Double> strong_adj_true = (ArrayList<Double>) Arrays.asList(list1);

		double strong_adjective_1f = 0.0;
		double strong_adjective_2f = 0.0;
		double strong_adjective_3f = 0.0;
		double strong_adjective_4f = 0.0;
		double strong_adjective_5f = 0.0;
		Double[] list2 = {strong_adjective_1f, strong_adjective_2f, strong_adjective_3f, strong_adjective_4f, strong_adjective_5f};
		ArrayList<Double> strong_adj_false = (ArrayList<Double>) Arrays.asList(list2);

		//occurrence of adjective
		double adjective_1t = 0.0;
		double adjective_2t = 0.0;
		double adjective_3t = 0.0;
		double adjective_4t = 0.0;
		double adjective_5t = 0.0;
		Double[] list3 = {adjective_1t, adjective_2t, adjective_3t, adjective_4t, adjective_5t};
		ArrayList<Double> adj_true = (ArrayList<Double>) Arrays.asList(list3);
		
		double adjective_1f = 0.0;
		double adjective_2f = 0.0;
		double adjective_3f = 0.0;
		double adjective_4f = 0.0;
		double adjective_5f = 0.0;
		Double[] list4 = {adjective_1f, adjective_2f, adjective_3f, adjective_4f, adjective_5f};
		ArrayList<Double> adj_false = (ArrayList<Double>) Arrays.asList(list4);

		//occurrence of strong adverb
		double strong_adverb_1t = 0.0;
		double strong_adverb_2t = 0.0;
		double strong_adverb_3t = 0.0;
		double strong_adverb_4t = 0.0;
		double strong_adverb_5t = 0.0;
		Double[] list5 = {strong_adverb_1t, strong_adverb_2t, strong_adverb_3t, strong_adverb_4t, strong_adverb_5t};
		ArrayList<Double> strong_adv_true = (ArrayList<Double>) Arrays.asList(list5);

		double strong_adverb_1f = 0.0;
		double strong_adverb_2f = 0.0;
		double strong_adverb_3f = 0.0;
		double strong_adverb_4f = 0.0;
		double strong_adverb_5f = 0.0;
		Double[] list6 = {strong_adverb_1f, strong_adverb_2f, strong_adverb_3f, strong_adverb_4f, strong_adverb_5f};
		ArrayList<Double> strong_adv_false = (ArrayList<Double>) Arrays.asList(list6);
		
		//occurrence of adverb
		double adverb_1t = 0.0;
		double adverb_2t = 0.0;
		double adverb_3t = 0.0;
		double adverb_4t = 0.0;
		double adverb_5t = 0.0;
		Double[] list7 = {adverb_1t, adverb_2t, adverb_3t, adverb_4t, adverb_5t};
		ArrayList<Double> adv_true = (ArrayList<Double>) Arrays.asList(list7);
		
		double adverb_1f = 0.0;
		double adverb_2f = 0.0;
		double adverb_3f = 0.0;
		double adverb_4f = 0.0;
		double adverb_5f = 0.0;
		Double[] list8 = {adverb_1f, adverb_2f, adverb_3f, adverb_4f, adverb_5f};
		ArrayList<Double> adv_false = (ArrayList<Double>) Arrays.asList(list8);
		
		ArrayList<ArrayList<Double>> variables_positive = new ArrayList<ArrayList<Double>>();
		variables_positive.add(strong_adj_true);
		variables_positive.add(adj_true);
		variables_positive.add(strong_adv_true);
		variables_positive.add(adv_true);
				
		ArrayList<ArrayList<Double>> variables_negative = new ArrayList<ArrayList<Double>>();
		variables_positive.add(strong_adj_false);
		variables_positive.add(adj_false);
		variables_positive.add(strong_adv_false);
		variables_positive.add(adv_false);
		
		// calculating probability of positiveness
		Double prob_positive = positive;
		
		for (int i=0; i<counts.length; i++) {
			for (int j = 0; j<counts[i]; j++) {
				prob_positive = prob_positive*variables_positive.get(i).get(j);
			}
			
			for (int k = counts[i]; k < 5; k++) {
				prob_positive = prob_positive*(1 - variables_positive.get(i).get(k));
			}
		}
		
		// calculating probability of negativeness
		Double prob_negative = negative;
		
		for (int i=0; i<counts.length; i++) {
			for (int j = 0; j<counts[i]; j++) {
				prob_negative = prob_negative*variables_negative.get(i).get(j);
			}
			
			for (int k = counts[i]; k < 5; k++) {
				prob_positive = prob_positive*(1 - variables_positive.get(i).get(k));
			}
		}
	}

}
