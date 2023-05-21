package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Hanoi {

	private Deque<Integer> leftDeque = new ArrayDeque<Integer>();
	private Deque<Integer> middleDeque = new ArrayDeque<Integer>();
	private Deque<Integer> rightDeque = new ArrayDeque<Integer>();

	public Hanoi() {
		for (int i = 9; i > 0 ; i--) {
			leftDeque.push(i);
		}
	}

	private Deque<Integer> originStack(char c) {
		switch (c) {
			case 'l': {
				return this.leftDeque;
			}
			case 'm': {
				return this.middleDeque;
			}
			case 'r': {
				return this.rightDeque;
			}
			default: {
				return null;
			}
		}
	}
	
	private void movePiece(char from, char to) {
		Deque<Integer> fromDeque = originStack(from);
		Deque<Integer> toDeque = originStack(to);

		if (fromDeque.isEmpty() || !toDeque.isEmpty() && fromDeque.peek() > toDeque.peek()) {
			System.out.println("Illegal move!");
		} else {
			toDeque.push(fromDeque.pop());
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
		return this.leftDeque.descendingIterator();
	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return this.middleDeque.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return this.rightDeque.descendingIterator();
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
