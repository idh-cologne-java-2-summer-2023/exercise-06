package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Hanoi {

	public Hanoi() {
		// TODO: Implement
		//on it
		System.out.println(getLeftDescendingIterator());
		System.out.println(getMiddleDescendingIterator());
		System.out.println(getRightDescendingIterator());
		run();
	}
	
	public void movePiece(String from, String to) {
		// TODO: Implement
		// on it                     <----------------------------------------wip
		int cargo;
		if(from.equals("l")){
           getLeftDescendingIterator(left.get(left.size()-1));
			cargo = left.get(left.size()-1);
		}
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target stick (will move top piece):");
				String s = br.readLine();
				if (s.matches("^([lmr])([lmr])$")) {
					char source = s.charAt(0);
					char target = s.charAt(1);
					movePiece(source, target);
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				// e.printStackTrace();
			} 
		}
	}
	
	public LinkedList<Integer> getLeftDescendingIterator() {
		//on it
	    LinkedList<Integer> left = new LinkedList<Integer>();
		Iterator <Integer> li = left.iterator();
		
		left.add (1);
		left.add (2);
		left.add (3);
		left.add (4);
		left.add (5);
		left.add (6);
		left.add (7);
		left.add (8);
		left.add (9);

		
//might have to change this so they are added at the start of a game instead
//of every time the method is called.
		return left;
     
	  }
	
	public Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		//on it
		LinkedList<Integer> middle = new LinkedList<Integer>();
		Iterator <Integer> mi = middle.iterator();

		return mi;


	}
	public Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		// on it
		LinkedList <Integer> right = new LinkedList<Integer>();
		Iterator <Integer> ri = right.iterator();
		return ri;

	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |");
		return b.toString();
	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}
