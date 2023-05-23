package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Document implements Iterable<String> {
	static String documentText;

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
	
	
//Ah, I see he went witth the "more elegant" option
	
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			 static ArrayList<String> Tokens = new ArrayList<String>();
			static ArrayList<String> Types = new ArrayList<String>();
			//We need the ArrayLists mostly for the type token collection, but I´m putting them here for accessibility
			//Sidebar: why don´t we do global variables anymore?

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			
			
			
			public boolean hasNext() {
				return tokenizer.hasMoreTokens();
			}

			
			public String next() {
				
				Tokens.add (tokenizer.nextToken());
				if (Types.contains(Tokens.get(Tokens.size()-1)) == false){
					Types.add(tokenizer.nextToken());
				}//Now we have a list of types and a list of tokens
				
				//So now let´s do something with that list:
				
				double ttr = Types.size() / Tokens.size();
				   System.out.println("Type token Ratio:" + ttr);
				
				return tokenizer.nextToken();


				
				

			    
			
			
			
			
		
			}};
	}
	
	public  final static void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		//for (String token : d) {
		//	System.out.println(i++ + ": " + token + " ");
		//	if (i > 100)
		//		break;
		while(tokenizer.hasNext() == true){
			tokenizer.next();
		}
		
	   
		}
		//Why can´t I call ANY of this in main?!
		
	
    
	}

//}
	

