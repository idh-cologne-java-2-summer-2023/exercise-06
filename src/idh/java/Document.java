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

	public double ttr() {
		int totalTokens = 0;
		int totalUniqueTokens;

		Set<String> uniqueTokens = new HashSet<>();

		//iteriert für jeden token in this.Document
		for (String token : this) {
			//für jeden token in this.Document -> token++
			totalTokens++;
			//Es werden einfach alle Token dem Hashset hinzugefügt. Mit Hashset "uniqueTokens" werden alle Tokens unique, da ein HashSet nur eindeutige Tokens speichern kann
			uniqueTokens.add(token);
		}

		//in den Wert der Anzahl der Tokens umwandeln
		totalUniqueTokens = uniqueTokens.size();
		System.out.println("totalUniqueTokens: " + totalUniqueTokens);
		System.out.println("totalTokens: " + totalTokens);

		//gibt double Ergebnis zurück
		return (double) totalUniqueTokens / totalTokens;
	}

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
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("../data/dracula.txt"));
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
		double ttrValue = d.ttr();
		System.out.println("TTR Value: " + ttrValue);
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
