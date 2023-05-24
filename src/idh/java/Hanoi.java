package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Hanoi<T> extends MyLinkedList<T> {
	
	 MyLinkedList<Integer> left = new MyLinkedList<Integer>();
	 MyLinkedList<Integer> middle = new MyLinkedList<Integer>();
	 MyLinkedList<Integer> right = new MyLinkedList<Integer>();

	public Hanoi() {
		 for(int i = 3; i >= 1; i--) {
			 left.add(i);
		 }
	}
	
	private void movePiece(char from, char to) {
		MyLinkedList<Integer> source;
		MyLinkedList<Integer> target;

		if(from == to) {
			System.out.println("Sie müssen zwei unterschiedliche Stäbe angeben.");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(from);
		sb.append(to);
		
		switch(sb.toString()) {
		case "lm":
			middle.add(left.getLast());
			left.removeLast();
			break;
		case "lr":
			right.add(left.getLast());
			left.removeLast();
			break;
		case "ml":
			left.add(middle.getLast());
			middle.removeLast();
			break;
		case "mr":
			right.add(middle.getLast());
			middle.removeLast();
			break;
		case "rl":
			left.add(right.getLast());
			right.removeLast();
			break;
		case "rm":
			middle.add(right.getLast());
			right.removeLast();
			break;
		default:
			System.out.println("Sie müssen zwei gültige Werte angeben");
		}
		
		 /*if (from == 'l') {
		        source = left;
		    } 
		 else if (from == 'm') {
		        source = middle;
		    } 
		 else if (from == 'r') {
		        source = right;
		    } 
		 else{
		    	System.out.println("Der eingegebene Stab existiert nicht.");
		    	return;
		    }

		 if (to == 'l') {
		        target = left;
		    } 
		 else if (to == 'm') {
		        target = middle;
		    } 
		 else if (to == 'r') {
		        target = right;
		    } 
		 else{
		    	System.out.println("Der eingegebene Stab existiert nicht.");
		        return;
		    }
		 
		  if(!source.isEmpty() && (target.isEmpty() || source.getLast() <= target.getLast())) {
			 if(to == 'l') {
				 left.add(source.getLast());
			 }
			 else if(to == 'm') {
				 middle.add(source.getLast());
			 }
			 else if(to == 'r') {
				 right.add(source.getLast());
			 }
			 
			 if(from == 'l') {
				 if(left.size() == 1) {
					 left.clear();
				 }
				 else {
				 left.remove(left.getLast());
				 }
			 }
			 else if(from == 'm') {
				 if(middle.size() == 1) {
					 middle.clear();
				 }
				 else {
				 middle.remove(middle.getLast());
				 }
			 }
			 else if(from == 'r') {
				 if(right.size() == 1) {
					 right.clear();
				 }
				 else {
				 right.remove(right.getLast());
				 }
			 }
		 }
		  else {
		        System.out.println("Die zu bewegende Scheibe darf nicht größer sein als die auf die sie draufgelegt wird.");
		  }*/
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
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return left.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return middle.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return right.iterator();
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
