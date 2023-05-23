package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Hanoi {

	ArrayDeque<Integer> l = new ArrayDeque<Integer>();
	ArrayDeque<Integer> m = new ArrayDeque<Integer>();
	ArrayDeque<Integer> r = new ArrayDeque<Integer>();

	public Hanoi() {
		for (int i = 9; i >= 1; i--) {
			this.l.push(i);
		}
	}

	private ArrayDeque<Integer> Tower(char from) {

		switch (from) {
		case 'l':
			return this.l;

		case 'm':
			return this.m;

		case 'r':
			return this.r;

		default:
			return null;

		}
	}

	private void movePiece(char from, char to) {

		ArrayDeque<Integer> fromT = this.Tower(from);
		ArrayDeque<Integer> toT = this.Tower(to);

		if (fromT.isEmpty()) {
			System.out.println("This stick is empty");
		} else if (!toT.isEmpty() && fromT.peekFirst() > toT.peekFirst()) {
			System.out.println("Disk is too big to be put there");
		} else {
			toT.add(fromT.pollLast());
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
					this.movePiece(source, target);
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				// e.printStackTrace();
				// Test commit for new author name
			}
		}
	}

	private Iterator<Integer> getLeftDescendingIterator() {
		return this.l.descendingIterator();

	}

	private Iterator<Integer> getMiddleDescendingIterator() {
		return this.m.descendingIterator();

	}

	private Iterator<Integer> getRightDescendingIterator() {
		return this.r.descendingIterator();
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while (iter.hasNext()) {
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