package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Hanoi {

	/*
	 * Tower of Hanoi Easy Mode with 3 instead of 9 (still complete mayhem) three
	 * instances of class Rod (left, middle, right) each Rod consists of a Deque of
	 * three Disc named one to three unnecessary classes help me keep track but also
	 * had me fail miserably
	 */

	public Hanoi() {

		Deque<Disc> l = new LinkedList<Disc>();
		Deque<Disc> m = new LinkedList<Disc>();
		Deque<Disc> r = new LinkedList<Disc>();

// 		create rod l: 
		// messed up by creating class Disc: can't find a way to make a for loop usable
		Disc discXS = new Disc(1);
		Disc discM = new Disc(2);
		Disc discXL = new Disc(3);
		l.add(discXL);
		l.add(discM);
		l.add(discXS);
		
//		create various placeholder Disc(0) for Rod m and Rod r)
		// see @ messing up in regards to loops
		for (int i = 0; i == 3; i++) {
			Disc disc = new Disc(i);
//			m.add(0);
//			r.add(0);
		}

	}

	private void movePiece(char from, char to) {
		Deque<Disc> takeDisc;
		Deque<Disc> placeDisc;

		// Implement LinkedList Methods: addLast() and removeLast()?

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

	// --- Code: N. Reiter
//	private Iterator<Integer> getLeftDescendingIterator() {
//		return null;
//	}
//	private Iterator<Integer> getMiddleDescendingIterator() {
//		return null;
//	}
//	private Iterator<Integer> getRightDescendingIterator() {
//		return null;
//	}
//	
//	public String toString() {
//		StringBuilder b = new StringBuilder();
//		b.append("  |\n l|");
//		Iterator<Integer> iter;
//		iter = this.getLeftDescendingIterator();
//		while(iter.hasNext()) {
//			b.append(iter.next());
//			b.append(' ');
//		}
//		b.append("\n  |\n m|");
//		iter = this.getMiddleDescendingIterator();
//		while(iter.hasNext()) {
//			b.append(iter.next());
//			b.append(' ');
//		}
//		b.append("\n  |\n r|");
//		iter = this.getRightDescendingIterator();
//		while(iter.hasNext()) {
//			b.append(iter.next());
//			b.append(' ');
//		}
//		b.append("\n  |");
//		return b.toString();
//	}

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();

	}

}
