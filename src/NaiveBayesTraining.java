import java.util.ArrayList;
import java.util.Arrays;

public class NaiveBayesTraining {

	public static void main(String[] args) {

		// prior prob
		double positive = 0.5;
		double negative = 0.5;

		// counts of words
		int strong_pos_adj =0, pos_adj=0, strong_pos_adv=0, pos_adv=0, strong_neg__adj=0, neg_adj=0, strong_neg_adv=0, neg_adv =0;
		Integer[] counts = { strong_pos_adj, pos_adj, strong_pos_adv, pos_adv, strong_neg__adj, neg_adj, strong_neg_adv, neg_adv };

		// occurrence of strong positive adjective
		double strong_adjective_1tp = 0.0;
		double strong_adjective_2tp = 0.0;
		double strong_adjective_3tp = 0.0;
		double strong_adjective_4tp = 0.0;
		double strong_adjective_5tp = 0.0;
		Double[] list1 = { strong_adjective_1tp, strong_adjective_2tp,
				strong_adjective_3tp, strong_adjective_4tp,
				strong_adjective_5tp };
		ArrayList<Double> strong_adj_true = (ArrayList<Double>) Arrays
				.asList(list1);

		double strong_adjective_1fp = 0.0;
		double strong_adjective_2fp = 0.0;
		double strong_adjective_3fp = 0.0;
		double strong_adjective_4fp = 0.0;
		double strong_adjective_5fp = 0.0;
		Double[] list2 = { strong_adjective_1fp, strong_adjective_2fp,
				strong_adjective_3fp, strong_adjective_4fp,
				strong_adjective_5fp };
		ArrayList<Double> strong_adj_false = (ArrayList<Double>) Arrays
				.asList(list2);

		// occurrence of strong negative adjective
		double strong_adjective_1tn = 0.0;
		double strong_adjective_2tn = 0.0;
		double strong_adjective_3tn = 0.0;
		double strong_adjective_4tn = 0.0;
		double strong_adjective_5tn = 0.0;
		Double[] list1n = { strong_adjective_1tn, strong_adjective_2tn,
				strong_adjective_3tn, strong_adjective_4tn,
				strong_adjective_5tn };
		ArrayList<Double> strong_neg_adj_true = (ArrayList<Double>) Arrays
				.asList(list1n);

		double strong_adjective_1fn = 0.0;
		double strong_adjective_2fn = 0.0;
		double strong_adjective_3fn = 0.0;
		double strong_adjective_4fn = 0.0;
		double strong_adjective_5fn = 0.0;
		Double[] list2n = { strong_adjective_1fn, strong_adjective_2fn,
				strong_adjective_3fn, strong_adjective_4fn,
				strong_adjective_5fn };
		ArrayList<Double> strong_neg_adj_false = (ArrayList<Double>) Arrays
				.asList(list2n);

		// occurrence of positive adjective
		double adjective_1t = 0.0;
		double adjective_2t = 0.0;
		double adjective_3t = 0.0;
		double adjective_4t = 0.0;
		double adjective_5t = 0.0;
		Double[] list3 = { adjective_1t, adjective_2t, adjective_3t,
				adjective_4t, adjective_5t };
		ArrayList<Double> adj_true = (ArrayList<Double>) Arrays.asList(list3);

		double adjective_1f = 0.0;
		double adjective_2f = 0.0;
		double adjective_3f = 0.0;
		double adjective_4f = 0.0;
		double adjective_5f = 0.0;
		Double[] list4 = { adjective_1f, adjective_2f, adjective_3f,
				adjective_4f, adjective_5f };
		ArrayList<Double> adj_false = (ArrayList<Double>) Arrays.asList(list4);

		// occurrence of negative adjective
		double adjective_1tn = 0.0;
		double adjective_2tn = 0.0;
		double adjective_3tn = 0.0;
		double adjective_4tn = 0.0;
		double adjective_5tn = 0.0;
		Double[] list3n = { adjective_1tn, adjective_2tn, adjective_3tn,
				adjective_4tn, adjective_5tn };
		ArrayList<Double> neg_adj_true = (ArrayList<Double>) Arrays
				.asList(list3n);

		double adjective_1fn = 0.0;
		double adjective_2fn = 0.0;
		double adjective_3fn = 0.0;
		double adjective_4fn = 0.0;
		double adjective_5fn = 0.0;
		Double[] list4n = { adjective_1fn, adjective_2fn, adjective_3fn,
				adjective_4fn, adjective_5fn };
		ArrayList<Double> neg_adj_false = (ArrayList<Double>) Arrays
				.asList(list4n);

		// occurrence of strong positive adverb
		double strong_adverb_1t = 0.0;
		double strong_adverb_2t = 0.0;
		double strong_adverb_3t = 0.0;
		double strong_adverb_4t = 0.0;
		double strong_adverb_5t = 0.0;
		Double[] list5 = { strong_adverb_1t, strong_adverb_2t,
				strong_adverb_3t, strong_adverb_4t, strong_adverb_5t };
		ArrayList<Double> strong_adv_true = (ArrayList<Double>) Arrays
				.asList(list5);

		double strong_adverb_1f = 0.0;
		double strong_adverb_2f = 0.0;
		double strong_adverb_3f = 0.0;
		double strong_adverb_4f = 0.0;
		double strong_adverb_5f = 0.0;
		Double[] list6 = { strong_adverb_1f, strong_adverb_2f,
				strong_adverb_3f, strong_adverb_4f, strong_adverb_5f };
		ArrayList<Double> strong_adv_false = (ArrayList<Double>) Arrays
				.asList(list6);

		// occurrence of strong negative adverb
		double strong_adverb_1tn = 0.0;
		double strong_adverb_2tn = 0.0;
		double strong_adverb_3tn = 0.0;
		double strong_adverb_4tn = 0.0;
		double strong_adverb_5tn = 0.0;
		Double[] list5n = { strong_adverb_1tn, strong_adverb_2tn,
				strong_adverb_3tn, strong_adverb_4tn, strong_adverb_5tn };
		ArrayList<Double> strong_neg_adv_true = (ArrayList<Double>) Arrays
				.asList(list5n);

		double strong_adverb_1fn = 0.0;
		double strong_adverb_2fn = 0.0;
		double strong_adverb_3fn = 0.0;
		double strong_adverb_4fn = 0.0;
		double strong_adverb_5fn = 0.0;
		Double[] list6n = { strong_adverb_1fn, strong_adverb_2fn,
				strong_adverb_3fn, strong_adverb_4fn, strong_adverb_5fn };
		ArrayList<Double> strong_neg_adv_false = (ArrayList<Double>) Arrays
				.asList(list6n);

		// occurrence of positive adverb
		double adverb_1t = 0.0;
		double adverb_2t = 0.0;
		double adverb_3t = 0.0;
		double adverb_4t = 0.0;
		double adverb_5t = 0.0;
		Double[] list7 = { adverb_1t, adverb_2t, adverb_3t, adverb_4t,
				adverb_5t };
		ArrayList<Double> adv_true = (ArrayList<Double>) Arrays.asList(list7);

		double adverb_1f = 0.0;
		double adverb_2f = 0.0;
		double adverb_3f = 0.0;
		double adverb_4f = 0.0;
		double adverb_5f = 0.0;
		Double[] list8 = { adverb_1f, adverb_2f, adverb_3f, adverb_4f,
				adverb_5f };
		ArrayList<Double> adv_false = (ArrayList<Double>) Arrays.asList(list8);

		// occurrence of negative adverb
		double adverb_1tn = 0.0;
		double adverb_2tn = 0.0;
		double adverb_3tn = 0.0;
		double adverb_4tn = 0.0;
		double adverb_5tn = 0.0;
		Double[] list7n = { adverb_1tn, adverb_2tn, adverb_3tn, adverb_4tn,
				adverb_5tn };
		ArrayList<Double> neg_adv_true = (ArrayList<Double>) Arrays
				.asList(list7n);

		double adverb_1fn = 0.0;
		double adverb_2fn = 0.0;
		double adverb_3fn = 0.0;
		double adverb_4fn = 0.0;
		double adverb_5fn = 0.0;
		Double[] list8n = { adverb_1fn, adverb_2fn, adverb_3fn, adverb_4fn,
				adverb_5fn };
		ArrayList<Double> neg_adv_false = (ArrayList<Double>) Arrays
				.asList(list8n);

		ArrayList<ArrayList<Double>> variables_positive = new ArrayList<ArrayList<Double>>();
		variables_positive.add(strong_adj_true);
		variables_positive.add(adj_true);
		variables_positive.add(strong_adv_true);
		variables_positive.add(adv_true);
		variables_positive.add(strong_neg_adj_true);
		variables_positive.add(neg_adj_true);
		variables_positive.add(strong_neg_adv_true);
		variables_positive.add(neg_adv_true);

		ArrayList<ArrayList<Double>> variables_negative = new ArrayList<ArrayList<Double>>();
		variables_positive.add(strong_adj_false);
		variables_positive.add(adj_false);
		variables_positive.add(strong_adv_false);
		variables_positive.add(adv_false);
		variables_positive.add(strong_neg_adj_false);
		variables_positive.add(neg_adj_false);
		variables_positive.add(strong_neg_adv_false);
		variables_positive.add(neg_adv_false);

		// calculating probability of positiveness
		Double prob_positive = positive;

		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				prob_positive = prob_positive
						* variables_positive.get(i).get(j);
			}

			for (int k = counts[i]; k < 5; k++) {
				prob_positive = prob_positive
						* (1 - variables_positive.get(i).get(k));
			}
		}

		// calculating probability of negativeness
		Double prob_negative = negative;

		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				prob_negative = prob_negative
						* variables_negative.get(i).get(j);
			}

			for (int k = counts[i]; k < 5; k++) {
				prob_positive = prob_positive
						* (1 - variables_positive.get(i).get(k));
			}
		}
	}
}
