package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

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
        Set<String> Wörter = new HashSet<>();
        int tokenCount = 0;
        for (String token : this) {
            Wörter.add(token);
            tokenCount++;
        }
        return (double) Wörter.getSize(tokenCount);
    
    }
	
	public static final void main(String[] args) throws IOException {
		Document dracu = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : dracu) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
		double ttr = dracu.ttr();
        System.out.println("TTR: " + ttr);
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


