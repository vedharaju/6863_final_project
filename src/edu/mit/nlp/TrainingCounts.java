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
	
	public static Integer[] tests(Integer[] counts){
		Integer[] answer = {0,0,0,0,0,0};
		
		if (counts[1] > 2*counts[3]) {
			answer[0] = 1;
		}
		
		if (counts[5] > 2*counts[7]) {
			answer[1] = 1;
		}
		
		if (counts[0] + counts[1] + counts[4] + counts[5] > counts[2] + counts[3] + counts[6] + counts[7]) {
			answer[2] = 1;
		}
		
		if (counts[3] > 2*counts[1]) {
			answer[3] = 1;
		}
		
		if (counts[7] > 2*counts[5]) {
			answer[3] = 1;
		}
		
		if (counts[2] + counts[3] + counts[6] + counts[7] > counts[0] + counts[1] + counts[4] + counts[5]) {
			answer[5] = 1;
		}
		return answer;
	}
	
	public static void main(String[] args) throws ClassNotFoundException,
	IOException {
		System.out.println("Running...");
		Integer[] test_counts = {0,0,0,0,0,0};
		Integer[] returnCounts;
	
		int count = 0;
		File dir = new File("./neg");
		for (File child: dir.listFiles()) {
			if (count > 99) {
				break;
			}
//			if (count == 5){
			returnCounts = counts(child);
			Integer[] update = tests(returnCounts);
			System.out.println("counts " + Arrays.toString(returnCounts));
//			System.out.println("update " + Arrays.toString(update));
			
			for (int i=0; i<update.length; i++){
				test_counts[i] += update[i];
			}
//			} 
			count++;
		}
		System.out.println("counts: " + Arrays.toString(test_counts));
	}
	
	public static Integer[] counts(File f) throws ClassNotFoundException, IOException {
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
