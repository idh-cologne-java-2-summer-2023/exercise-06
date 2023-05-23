package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;

public class Hanoi {
	Deque<Integer> qLeft = new ArrayDeque<>();
	Deque<Integer> qMiddle = new ArrayDeque<>();
	Deque<Integer> qRight = new ArrayDeque<>();

	public Hanoi() {
		for (int i = 9; i >= 1; i--) {
			this.qLeft.push(i);
		}
	}

	private void movePiece(char from, char to) {
		int buffer = 0;
		switch (from) {
		case 'l': {
			buffer = qLeft.pop();
			switch (to) {
			case 'l': {
				qLeft.push(buffer);
				break;
			}
			case 'm': {
				qMiddle.push(buffer);
				break;
			}
			case 'r': {
				qRight.push(buffer);
				break;
			}
			}
			break;
		}
		case 'm': {
			buffer = qMiddle.pop();
			switch (to) {
			case 'l': {
				qLeft.push(buffer);
				break;
			}
			case 'm': {
				qMiddle.push(buffer);
				break;
			}
			case 'r': {
				qRight.push(buffer);
				break;
			}
			}
			break;
		}

		case 'r': {
			buffer = qRight.pop();
			switch (to) {
			case 'l': {
				qLeft.push(buffer);
				break;
			}
			case 'm': {
				qMiddle.push(buffer);
				break;
			}
			case 'r': {
				qRight.push(buffer);
				break;
			}
			}
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

	private Iterator<Integer> getLeftDescendingIterator() {
		return this.qLeft.descendingIterator();

	}

	private Iterator<Integer> getMiddleDescendingIterator() {
		return this.qMiddle.descendingIterator();

	}

	private Iterator<Integer> getRightDescendingIterator() {
		return this.qRight.descendingIterator();
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
