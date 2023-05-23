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
	
	public double ttr() {
		Set<String> types = new HashSet<>();
		int tokenCount = 0;

		for (String token : this) {
			tokenCount++;
			types.add(token);
		}

		return (double) types.size() / tokenCount;
	}

	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}

		double ttrValue = d.ttr();
		System.out.println("TTR: " + ttrValue);
	}

	@Override
	public Iterator<String> iterator() {
		return new StringTokenizerIterator(new StringTokenizer(documentText));
	}
	
	private static class StringTokenizerIterator implements Iterator<String> {
		private StringTokenizer tokenizer;

		public StringTokenizerIterator(StringTokenizer tokenizer) {
			this.tokenizer = tokenizer;
		}

		@Override
		public boolean hasNext() {
			return tokenizer.hasMoreTokens();
		}

		@Override
		public String next() {
			return tokenizer.nextToken();
		}
	}
}
