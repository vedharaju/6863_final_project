import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Categorizer {

	ArrayList<String> negative = new ArrayList<String>();
	ArrayList<String> positive = new ArrayList<String>();
	
	Categorizer(FileReader pos, FileReader neg) {
		String line;
		try {
			BufferedReader bufRead = new BufferedReader(pos);
			while((line = bufRead.readLine()) != null) {
				line = line.trim(); 
				if (line != null){
					positive.add(line);
				}
			}
			
			bufRead = new BufferedReader(neg);
			while((line = bufRead.readLine()) != null) {
				line = line.trim(); 
				if (line != null){
					negative.add(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isPositive(String word) {
		if (positive.contains(word)) {
			return true;
		} else {
			return false;
		}
	}
	
	public HashMap<String, Integer> findPolarity(ArrayList<String> words) {
		HashMap<String, Integer> answer = new HashMap<String, Integer>();
		for (int i = 0; i<words.size();i++){
			if (isPositive(words.get(i))) {
				answer.put(words.get(i), 1);
			} else {
				answer.put(words.get(i), -1);
			}
		}
		return answer;
		
	}
}
