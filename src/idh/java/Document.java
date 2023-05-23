package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	
	String documentText;
	int tokenCounter = 0;

		public static Document readFromFile(File f) throws IOException {
			FileReader fileReader = new FileReader(f);
			int ch;
			StringBuilder b = new StringBuilder();
			while( (ch = fileReader.read()) != -1 ) {
				b.append((char) ch);
			}
			fileReader.close();
			Document doc = new Document();
			doc.documentText = b.toString();
			
			return doc;
		}
	
	public String getDocumentText() {
		return documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}
	
	public int getTokenCounter() {
		return tokenCounter;
	}
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		
		/*
		 * for (String docText : d) { System.out.println(docText);
		 * 
		 * }
		 */
		
	
			System.out.println(d.ttr());
		
	
	}
	


	public Iterator<String> iterator() {
			return new Iterator<String>() {

				StringTokenizer tokenizer = new StringTokenizer(documentText);
				
				@Override
				public boolean hasNext() {
					return tokenizer.hasMoreTokens();
				}

				@Override
				public String next() {
					return tokenizer.nextToken();
				}
				
			};
		}
	
	
	/*
	 * public boolean equals(Object o) { if (! (o instanceof String)) return false;
	 * String s = (String) o; String t = String.valueOf(this); return
	 * s.equalsIgnoreCase(t); }
	 */
	
	
 	
	
	public double ttr() {
		Set<String> trrSet = new HashSet<String>();
		int tokenCounter = 0;
		
		for (String token : this) {
			tokenCounter++;
			trrSet.add(this.iterator().next());;
		}
		
		int setSize = trrSet.size();
		
		
		double trr = (double) setSize/tokenCounter;
		return trr;
	}
	
}

