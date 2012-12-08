import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

import com.aliasi.hmm.HiddenMarkovModel;
import com.aliasi.hmm.HmmDecoder;
import com.aliasi.tag.Tagging;
import com.aliasi.tokenizer.RegExTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.util.Streams;

public class RunMedPost {

	static TokenizerFactory TOKENIZER_FACTORY = new RegExTokenizerFactory(
			"(-|'|\\d|\\p{L})+|\\S");

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {

		String filename = "/Users/vedharaju/MIT 3.1/6.863/FinalProjectWorkspace/LingPipeDir/demos/models/pos-en-general-brown.HiddenMarkovModel";
		System.out.println("Reading model from file=" + filename);
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		HiddenMarkovModel hmm = (HiddenMarkovModel) objIn.readObject();
		Streams.closeQuietly(objIn);
		HmmDecoder decoder = new HmmDecoder(hmm);

		InputStreamReader isReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(isReader);
		while (true) {
			System.out.print("\n\nINPUT> ");
			System.out.flush();
			String line = bufReader.readLine();
			if (line == null || line.length() < 1
					|| line.equalsIgnoreCase("quit")
					|| line.equalsIgnoreCase("exit"))
				break;
			char[] cs = line.toCharArray();

			Tokenizer tokenizer = TOKENIZER_FACTORY.tokenizer(cs, 0, cs.length);
			String[] tokens = tokenizer.tokenize();
			List<String> tokenList = Arrays.asList(tokens);

			firstBest(tokenList, decoder);
		}
		Streams.closeQuietly(bufReader);
	}

	static void firstBest(List<String> tokenList, HmmDecoder decoder) {
		Tagging<String> tagging = decoder.tag(tokenList);
		System.out.println("\nFIRST BEST");
		for (int i = 0; i < tagging.size(); ++i)
			System.out.print(tagging.token(i) + "_" + tagging.tag(i) + " ");
		System.out.println();

	}
}
