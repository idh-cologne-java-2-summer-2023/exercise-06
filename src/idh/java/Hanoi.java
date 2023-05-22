package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {

	Deque <Integer> leftDQ = new LinkedList <>();
	
	Deque <Integer> middleDQ = new LinkedList <>();
	
	Deque <Integer> rightDQ = new LinkedList <>();
	
	public Hanoi() {
		
		leftDQ.addFirst(1);
	    leftDQ.addLast(2);
	    leftDQ.addLast(3);
	    leftDQ.addLast(4);
	    leftDQ.addLast(5);
	    leftDQ.addLast(6);
	    leftDQ.addLast(7);
	    leftDQ.addLast(8);
	    leftDQ.addLast(9);
	    
		
	}
	
	private void movePiece(char from, char to) {
		
		if (from == 'l') {
			switch (to) {
			case 'm':
				if (middleDQ.peek() == null || leftDQ.peek() < middleDQ.peek()) { // Nur wenn "to" keine Scheibe hat oder eine größere Scheibe hat als die bewegte Scheibe, wird es ausgeführt
					middleDQ.addFirst(leftDQ.poll());
				} else System.err.println("Invalid Move");
				break;
			case 'r':
				if (rightDQ.peek() == null || leftDQ.peek() < rightDQ.peek()) {
				rightDQ.addFirst(leftDQ.poll());
				} else System.err.println("Invalid Move");
				break;
			default:
				System.err.println("Invalid Command");
			}
		} else 
			
			if (from == 'm') {
			switch (to) {
			case 'l':
				if (leftDQ.peek() == null || middleDQ.peek() < leftDQ.peek()) {
				leftDQ.addFirst(middleDQ.poll());
				} else System.err.println("Invalid Move");
				break;
			case 'r':
				if (rightDQ.peek() == null || middleDQ.peek() < rightDQ.peek()) {
				rightDQ.addFirst(middleDQ.poll());
				} else System.err.println("Invalid Move");
				break;
			default:
				System.err.println("Invalid Command");
			}
		} else 
			
			if (from == 'r') {
			switch (to) {
			case 'm':
				if (middleDQ.peek() == null || rightDQ.peek() < middleDQ.peek()) {
				middleDQ.addFirst(rightDQ.poll());
				} else System.err.println("Invalid Move");
				break;
			case 'l':
				if (leftDQ.peek() == null || rightDQ.peek() < leftDQ.peek()) {
				leftDQ.addFirst(rightDQ.poll());
				} else System.err.println("Invalid Move");
				break;
			default:
				System.err.println("Invalid Command");
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
		return leftDQ.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return middleDQ.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return rightDQ.descendingIterator();
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
