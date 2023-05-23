package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Hanoi {

	Deque<Integer> leftTower;
	Deque<Integer> middleTower;
	Deque<Integer> rightTower;
	final int STACK_SIZE = 9;

	public Hanoi() {
		leftTower = new ArrayDeque<>();
		middleTower = new ArrayDeque<>();
		rightTower = new ArrayDeque<>();

		for (int i = 0; i < STACK_SIZE; i++) {
			leftTower.push(i + 1);
		}
	}

	private void movePiece(char from, char to) {
		Deque<Integer> fromTower = getTower(from);
		Deque<Integer> toTower = getTower(to);

		if (fromTower.isEmpty()) {
			System.out.println("The source tower is empty. Try another one.");
		} else if (!toTower.isEmpty() && fromTower.peek() > toTower.peek()) {
			System.out.println("You can't pile a larger disc on top of a smaller disc! Come on, follow the rules!");
		} else {
			toTower.push(fromTower.pop());
		}
	}
//
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
			}
		}
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = getDescendingIterator(leftTower);
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = getDescendingIterator(middleTower);
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = getDescendingIterator(rightTower);
		while (iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |");
		return b.toString();
	}

	private Deque<Integer> getTower(char rod) {
		switch (Character.toLowerCase(rod)) {
		case 'l':
			return leftTower;
		case 'm':
			return middleTower;
		case 'r':
			return rightTower;
		default:
			System.out.println("Try again, something's not right.");
			return null;
		}
	}

	private Iterator<Integer> getDescendingIterator(Deque<Integer> rod) {
		return rod.descendingIterator();
	}

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}