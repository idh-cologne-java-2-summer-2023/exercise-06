package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	
	class DocumentIterator implements Iterator<String> {
		Document docText;
		int currentPosition = -1;
		StringTokenizer st;
		
		public DocumentIterator(Document document) {
			this.docText = document;
			this.st = new StringTokenizer(docText.documentText);
		}
	
		public boolean hasNext() {
			return currentPosition < st.countTokens();
		}
	
		public String next() {
			currentPosition++;
			tokenCounter++;
			return (String) st.nextElement();
		}
		
		
	}
	
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
		return new DocumentIterator(this);
	}
	
	public boolean equals(Object o) {
		if (! (o instanceof String))
			return false;
		String s = (String) o;
		String t = String.valueOf(this);
		return s.equalsIgnoreCase(t);
	}
	
	
 	
	
	public double ttr() {
		Set<String> trrSet = new HashSet<String>();
		trrSet.add(this.iterator().next());
		int setSize = trrSet.size();
		
		int tokenCounter = this.getTokenCounter();
		
		double trr = setSize/tokenCounter;
		return trr;
	}
	
}

