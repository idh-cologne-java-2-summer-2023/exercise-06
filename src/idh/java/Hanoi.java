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
		LinkedList<Integer> left = new LinkedList<Integer>();
		LinkedList<Integer> middle = new LinkedList<Integer>();
		LinkedList <Integer> right = new LinkedList<Integer>();

		System.out.println(getLeftDescendingIterator());
		System.out.println(getMiddleDescendingIterator());
		System.out.println(getRightDescendingIterator());
		run();
		if(getRightDescendingIterator(ri.size().equals(9))){
			System.out.println("Thank you for playing, you win. Oh, joy.");
		

		}
	}
	
	public void movePiece(String from, String to) {
		// TODO: Implement
		// on it                     <----------------------------------------wip
		//moving things from the left stack
		int cargo;
		if(from.equals("l")){
           getLeftDescendingIterator(li.get(li.size()-1));
			cargo = li.get(li.size()-1);

			if (to.equals("m")| cargo < getMiddleDescendingIterator(mi.get(mi.size()-1))){
				mi.add(cargo);
				cargo = 0;
				li.removeLast();

			}
				if (cargo > getMiddleDescendingIterator(mi.get(mi.size()-1))){
					System.out.println("Can only place smaller disks on bigger ones.");
					cargo =0;
					break;

				}

			
		}
//moving things from the middle stack
		if (from.equals("m")){
			getMiddleDescendingIterator(mi.get(mi.size()-1));
			cargo = mi.get(mi.size()-1);
			if (to.equals("l")| cargo < getLeftDescendingIterator(li.get(li.size()-1))){
				li.add(cargo);
				cargo = 0;
				mi.removeLast();
			
			if (cargo > getLeftDescendingIterator(li.get(li.size()-1))){
				System.out.println("Can only place smaller disks on bigger ones.");
				cargo = 0;
				break;
			}

			}

			if (to.equals("r")| cargo < getRightDescendingIterator(ri.get(ri.size()-1))){
				ri.add(cargo);
				cargo = 0;
				mi.removeLast();
			}
			if(cargo > getRightDescendingIterator(ri.get(ri.size()-1))){
				System.out.println("Can only place smaller disks on bigger ones.");
				cargo = 0;
				break;
			}
		}//moving things from the right stack
		if(from.equals("r")){
			getRightDescendingIterator(ri.gety(ri.size()-1));
			cargo = ri.get(ri.size()-1);

			if(to.equals("m")| cargo < mi.get(mi.size()-1)){
				ri.add(cargo);
				cargo = 0;
				mi.removeLast();
			}
			if(cargo > mi.get(mi.size()-1)){
				System.out.println("Can only place smaller disks on bigger ones.");
				cargo = 0;
				break;
			}
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
		return li;
     
	  }
	
	public Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		//on it
		
		Iterator <Integer> mi = middle.iterator();

		return mi;


	}
	public Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		// on it
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
