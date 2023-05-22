package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayDeque;

public class Hanoi {
	ArrayDeque<Integer> l = new ArrayDeque<Integer>();
	ArrayDeque<Integer> m = new ArrayDeque<Integer>();
	ArrayDeque<Integer> r = new ArrayDeque<Integer>();

	public Hanoi() {
		for (int i = 9; i > 0; i--) {
			l.add(i);
		}
	}

	private ArrayDeque<Integer> getTower(char c) {
		switch (c) {
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
		ArrayDeque<Integer> fromTower = getTower(from);
		ArrayDeque<Integer> toTower = getTower(to);

		if (fromTower.isEmpty()) {
			System.out.println("The chosen source stick is empty!");
		} else if (!toTower.isEmpty() && fromTower.peekFirst() > toTower.peekFirst()) {
			System.out.println("The chosen piece is bigger than the top piece of the target stick!");
		} else {
			toTower.add(fromTower.pollLast());
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
		return l.iterator();

	}

	private Iterator<Integer> getMiddleDescendingIterator() {
		return m.iterator();

	}

	private Iterator<Integer> getRightDescendingIterator() {
		return r.iterator();
	}

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
