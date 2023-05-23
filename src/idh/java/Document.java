package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.HashSet; 

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
	
	public static final void main(String[] args) throws IOException {
		HashSet myHashSet = new HashSet();
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)//hier wird die maximale Zeilenanzahl der Konsolenausgabe begrenzt. Standardwert ist 100
				//hier einbauen, dass der Token zu einer Liste/Hashset hinzugefügt wird
//				myHashSet.add(token);
//			String test = myHashSet.toString();
//			System.out.println(test);
				break;
		}
	}
//	public String toString() {
//		System.out.println(myHashSet);
//
//		return null;
//	}

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
	//Funktion ttr()
//	
//	public double ttr() {
//		
//		
//		double ret = 0;
//		
//		return ret;
//	}
//	
	
}
