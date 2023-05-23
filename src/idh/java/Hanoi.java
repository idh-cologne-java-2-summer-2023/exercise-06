package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	
	Deque <Integer> left = new LinkedList<>();
	Deque <Integer> middle = new LinkedList<>();
	Deque <Integer> right = new LinkedList<>();

	public Hanoi() {
		
		left.addFirst(1);
		left.addLast(2);
		left.addLast(3);
		left.addLast(4);
		left.addLast(5);
		left.addLast(6);
		left.addLast(7);
		left.addLast(8);
		left.addLast(9);	
		
	}
	
	private void movePiece(char from, char to) {
		
		//Nur wenn "to" (Ziel) keine Scheibe hat (== null) oder größer ist als "from" (Start), ist ein Zug gültig.
		
		if (from == 'l') {
			switch (to) {
			case 'm':
				if (middle.peek() == null || left.peek() < middle.peek()) { 
					middle.addFirst(left.poll());
				} else System.out.println("Zug ungültig");
				break;
			case 'r':
				if (right.peek() == null || left.peek() < right.peek()) {
					right.addFirst(left.poll());
				} else System.out.println("Zug ungültig");
				break;
			default:
				System.out.println("Eingabe ungültig");
			}
		} else 
		
			if (from == 'm') {
				switch (to) {
				case 'l':
					if (left.peek() == null || middle.peek() < left.peek()) { 
						left.addFirst(middle.poll());
					} else System.out.println("Zug ungültig");
					break;
				case 'r':
					if (right.peek() == null || middle.peek() < right.peek()) {
						right.addFirst(middle.poll());
					} else System.out.println("Zug ungültig");
					break;
				default:
					System.out.println("Eingabe ungültig");
				}
			} else 
		
				if (from == 'r') {
					switch (to) {
					case 'm':
						if (middle.peek() == null || right.peek() < middle.peek()) { 
							middle.addFirst(right.poll());
						} else System.out.println("Zug ungültig");
						break;
					case 'l':
						if (left.peek() == null || right.peek() < left.peek()) {
							left.addFirst(right.poll());
						} else System.out.println("Zug ungültig");
						break;
					default:
						System.out.println("Eingabe ungültig");
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
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return left.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return middle.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return right.descendingIterator();
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
