package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Hanoi {

	private Deque<Integer> left;
	private Deque<Integer> middle;
	private Deque<Integer> right;
	
	public Hanoi() {
		left = new ArrayDeque<>();
		middle = new ArrayDeque<>();
		right = new ArrayDeque<>();
		
		for (int i = 3; i >= 1; i--) {
			left.push(i);
		}
	}
	
	private void movePiece(char from, char to) {
		Deque<Integer> source = getTower(from);
		Deque<Integer> target = getTower(to);
		
		if (source == null || target == null) {
			System.out.println("Invalid move. Please enter valid source and target towers.");
			return;
		}
		
		if (source.isEmpty()) {
			System.out.println("Invalid move. The source tower is empty.");
			return;
		}
		
		if (!target.isEmpty() && source.peek() > target.peek()) {
			System.out.println("Invalid move. Cannot place a larger disc on top of a smaller disc.");
			return;
		}
		
		int disc = source.pop();
		target.push(disc);
	}
	
	private Deque<Integer> getTower(char tower) {
		switch (tower) {
			case 'l':
				return left;
			case 'm':
				return middle;
			case 'r':
				return right;
			default:
				return null;
		}
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target tower (e.g., 'lm' to move from left to middle): ");
				String input = br.readLine();
				
				if (input.matches("^([lmr])([lmr])$")) {
					char source = input.charAt(0);
					char target = input.charAt(1);
					movePiece(source, target);
				} else {
					System.out.println("Invalid input. Please enter source and target towers (e.g., 'lm').");
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				// e.printStackTrace();
			} 
		}
	}
	
	private Iterator<Integer> getDescendingIterator(Deque<Integer> tower) {
		return tower.descendingIterator();
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter = getDescendingIterator(left);
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = getDescendingIterator(middle);
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = getDescendingIterator(right);
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

