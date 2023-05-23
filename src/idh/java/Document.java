
package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	String documentText;
	static int typeCounter = 0;
	static int tokenCounter = 0;

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
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		HashSet<String> bruh = new HashSet<String>();
		
		int i = 0;
		for (String token : d) {
			
			if(bruh.add(token)){
				bruh.add(token);
				typeCounter++;
			}
				
			System.out.println(i++ + ": " + token + " ");
			tokenCounter++;
		//	if (i > 100)
		//		break;
		}
		System.out.println(ttr());
	}

	@Override
	public Iterator<String> iterator() {
		//HashSet<String> bruh = new HashSet<String>();
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
	
	public static double ttr() {
		return (double) typeCounter / (double) tokenCounter;
	}
	
}
