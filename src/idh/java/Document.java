package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;




public class Document implements Iterable<String> {
	
	String documentText;
	String draculaSet;
	

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
		
		int i = 0;
		for (String token : d) {
			
			Set<String> draculaSet = new HashSet<String>();
			draculaSet.add(token);
			System.out.println("HashCode : " + draculaSet.hashCode());
			System.out.println( i++ + ": " + token + " ");
			 if (i > 100)
			break;
			} 	
	}       	
	

	@Override
	public int hashCode() {
		int result = 1;
		result = ((draculaSet == null) ?  0 : draculaSet.hashCode());
		System.out.println(draculaSet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		return Objects.equals(draculaSet, other.draculaSet);
	} //didn't know how to implement this correctly but I think it's part of the solution -> deletes duplicates.
	

				public double ttr() {
	    
		          double ttr = 8 / 100;
		
		         System.out.println("RESULT : " + ttr);
 /*result would be 0,1231 ( / 65 ) or 0,08 ( / 100 ) which is both wrong. Couldn't filter duplicates and couldn't understand
		         if we need to take the whole text or just the tokens up until 100. */
		         return ttr;
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
