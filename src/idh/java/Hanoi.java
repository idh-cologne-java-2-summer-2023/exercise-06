package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Hanoi {
	Deque<Integer> links;
	Deque<Integer> mitte;
	Deque<Integer> rechts;
	
	public Hanoi() {
		this.links = new LinkedList<Integer>();
		this.mitte = new LinkedList<Integer>();
		this.rechts = new LinkedList<Integer>();
		
		links.add(9);
		links.add(8);
		links.add(7);
		links.add(6);
		links.add(5);
		links.add(4);
		links.add(3);

		this.toString();
	}
	
	private void movePiece(char from, char to) {
		String s = new StringBuilder().append(from).append(to).toString();
		switch(s) {
			case "lm":
				mitte.add(links.removeLast());
				break;
			case "lr":
				rechts.add(links.removeLast());
				break;
			case "ml":
				links.add(mitte.removeLast());
				break;
			case "mr":
				rechts.add(mitte.removeLast());
				break;
			case "rl":
				links.add(rechts.removeLast());
				break;
			case "rm":
				mitte.add(rechts.removeLast());
				break;	
			default:
				System.out.println("Something must went wrong here");
				
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
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return links.iterator();
	}

	private Iterator<Integer> getMiddleDescendingIterator() {
				return mitte.iterator();
			}
			
	private Iterator<Integer> getRightDescendingIterator() {
		return rechts.iterator();
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
