package edu.mit.nlp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.aliasi.tag.Tagging;

public class TrainingCounts {

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
		ArrayList<Integer> strong_adj = new ArrayList<Integer>(5);
		ArrayList<Integer> adj = new ArrayList<Integer>(5);
		ArrayList<Integer> strong_adv = new ArrayList<Integer>(5);
		ArrayList<Integer> adv = new ArrayList<Integer>(5);
		ArrayList<Integer> strong_neg_adj = new ArrayList<Integer>(5);
		ArrayList<Integer> neg_adj = new ArrayList<Integer>(5);
		ArrayList<Integer> strong_neg_adv = new ArrayList<Integer>(5);
		ArrayList<Integer> neg_adv = new ArrayList<Integer>(5);
		
		ArrayList<ArrayList<Integer>> finalCounts = new ArrayList<ArrayList<Integer>>();
		finalCounts.add(adj);
		finalCounts.add(strong_adj);
		finalCounts.add(neg_adj);
		finalCounts.add(strong_neg_adj);
		finalCounts.add(adv);
		finalCounts.add(strong_adv);
		finalCounts.add(neg_adv);
		finalCounts.add(strong_neg_adv);
		ArrayList<Integer> returnCounts = new ArrayList<Integer>();
	
		int count = 0;
		File dir = new File("./pos");
		for (File child: dir.listFiles()) {
			if (count > 3) {
				break;
			}
			returnCounts = counts(child);
			System.out.println("summary " + returnCounts);
			for (int i=0; i<returnCounts.size(); i++) {
				int x = returnCounts.get(i);
				ArrayList<Integer> temp = finalCounts.get(i);
				int index = Math.max(x, 5) - 1;
				temp.set(index, temp.get(index) + 1);
			}
			count++;
		}
	}
	
	public static ArrayList<Integer> counts(File f) throws ClassNotFoundException, IOException {
		return Main.getSummary(Main.process(readFile(f)));
	}
	
	private static String readFile( File file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
}
