package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	private Deque<Integer> l = new LinkedList<Integer>();
	private Deque<Integer> m = new LinkedList<Integer>();
	private Deque<Integer> r = new LinkedList<Integer>();

	public Hanoi() {
		for (int i = 9; i > 0; i--) {
			l.add(i);
		}
	}

	private void movePiece(char from, char to) {
		Integer lastNum;
		// TODO: Implement
		// von l einen weg zu m drauf: Randfall
		if (from == 'l') {

			lastNum = l.peekLast();

			if (to == 'm') {

				if (m.isEmpty() || lastNum < m.peekLast()) {
					l.removeLast();
					m.add(lastNum);

				}

				else
					System.out.print("(-) the stone is too big :(");
			}

			if (to == 'r') {

				if (r.isEmpty() || lastNum < r.peekLast()) {
					l.removeLast();
					r.add(lastNum);
				} else
					System.out.print("(-) the stone is too big :(");
				
			}

			} else if (from == 'm') {
				if (to == 'l') {
					lastNum = m.peekLast();

					if (l.isEmpty() || lastNum < l.peekLast()) {
						m.removeLast();
						l.add(lastNum);
					}
				}
				if (to == 'r') {
					lastNum = m.peekLast();

					if (r.isEmpty() || lastNum < r.peekLast()) {
						m.removeLast();
						r.add(lastNum);
					}

				}
			} else if (from == 'r') {
				if (to == 'm') {
					lastNum = r.peekLast();

					if (m.isEmpty() || lastNum < m.peekLast()) {
						r.removeLast();
						m.add(lastNum);

					}
				}
				if (to == 'l') {
					lastNum = r.removeLast();

					if (l.isEmpty() || lastNum < l.peekLast()) {
						r.removeLast();
						l.add(lastNum);
					}
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

				e.printStackTrace();
			}
		}
	}

	private Iterator<Integer> getLeftDescendingIterator() {

		// TODO: Implement
		return l.iterator();

	}

	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return m.iterator();

	}

	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
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
