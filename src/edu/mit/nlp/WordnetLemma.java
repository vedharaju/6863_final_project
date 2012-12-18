package edu.mit.nlp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.IRAMDictionary;
import edu.mit.jwi.RAMDictionary;
import edu.mit.jwi.data.ILoadPolicy;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;
import edu.mit.jwi.morph.IStemmer;
import edu.mit.jwi.morph.WordnetStemmer;

public class WordnetLemma {
	IDictionary dict;

	public void loadDictionary() {
		String wnhome = System.getenv("WNHOME");
		wnhome = "/Users/pbotla/dev/nlp/WordNet-3.0/";
		File wnDir = new File(wnhome);
		try {
			this.testRAMDictionary(wnDir);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String path = wnhome + File.separator + "dict";
		URL url = null;
		try{ url = new URL("file", null, path); }  
		catch(MalformedURLException e){ e.printStackTrace(); }
		if(url == null) return;

		// construct the dictionary object and open it
		dict = new Dictionary(url);
		try {
			dict.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getLemma(String surface_word, POS pos) {
		// look up first sense of the word "dog"
		IIndexWord idxWord = dict.getIndexWord(surface_word, pos);
		if (idxWord != null) {
			IWordID wordID = idxWord.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);

			System.out.println(word);
			System.out.println("Id = " + wordID);
			System.out.println("Lemma = " + word.getLemma());
			System.out.println("Gloss = " + word.getSynset().getGloss());

			return word.getLemma();
		} else {
			return surface_word;
		}
	}

	public static void main(String[] args){

		// construct the URL to the Wordnet dictionary directory
		WordnetLemma testWordnet = new WordnetLemma();
		testWordnet.loadDictionary();
		System.out.println(testWordnet.getLemma("dog", POS.ADJECTIVE));
		System.out.println(testWordnet.getLemma("brilliant", POS.ADJECTIVE));
		System.out.println(testWordnet.getLemma("excellence", POS.ADJECTIVE));

	} 

	public  void testRAMDictionary ( File wnDir ) throws Exception {

		// construct the dictionary object and open it
		IRAMDictionary dict = new RAMDictionary (wnDir , ILoadPolicy . NO_LOAD );
		dict.open ();
		this.dict = dict;

		// do something
		trek ( dict );

		// now load into memory
		System.out.println("Loading Wordnet into memory ... ");
		long t = System . currentTimeMillis ();
		dict . load ( true );
		System .out . printf (" done (%1 d msec )\n", System . currentTimeMillis () -t);

		// try it again , this time in memory
		trek ( dict );
	}

	public void trek ( IDictionary dict ){
		int tickNext = 0;
		int tickSize = 20000;
		int seen = 0;
		System .out . print (" Treking across Wordnet ");
		long t = System . currentTimeMillis ();
		for(POS pos : POS. values ())
			for(Iterator < IIndexWord > i = dict . getIndexWordIterator (pos); i.
					hasNext (); )
				for( IWordID wid : i. next (). getWordIDs ()){
					seen += dict . getWord (wid ). getSynset (). getWords (). size ();
					if( seen > tickNext ){
						System . out. print ('.');
						tickNext = seen + tickSize ;
					}
				}
		System .out . printf (" done (%1 d msec )\n", System . currentTimeMillis () -t);
		System .out . println ("In my trek I saw " + seen + " words ");
	}


}
