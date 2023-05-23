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
	
	public static double ttr(Document doc) {
		//Anzahl der tokens mit Hilfe eines Arrays berechnen
		int i = 0;
		int anzahlTokens = 0;
		for (String token : doc) {
			anzahlTokens++;
		}
		
		System.out.println("Anzahl Tokens: " + anzahlTokens);
		//Anzahl der types mit Hilfe eines Sets berechnen
		Set<String> set = new HashSet<String> ();
		int j = 0;
		for (String token : doc) {
			set.add(token);
		}
		int anzahlTypes = set.size();
		
		System.out.println("Anzahl Types: " + anzahlTypes);
		return ((double) anzahlTypes / (double) anzahlTokens);
	}
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
		
		System.out.println("TTR: " + ttr(d));
		
	}

	@Override
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
	
	
}
