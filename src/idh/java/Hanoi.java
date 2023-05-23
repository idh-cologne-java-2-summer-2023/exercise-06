package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hanoi {
	private List<Integer> left;
	List<Integer> middle = new ArrayList<>();
	List<Integer> right = new ArrayList<>();

	public Hanoi() {
		left = new ArrayList<>();
		//initialisiere Links nur für Start des Programms
		for (int i = 9; i >=1; i--) {
			left.add(i);
		}
	}
	
	private void movePiece(char from, char to) {
		//Warum listen init?
		List<Integer> source;
		List<Integer> target;

		if (from == 'l') {
			source = left;
		} else if (from == 'm') {
			source = middle;
		} else if (from == 'r') {
			source = right;
		} else {
			throw new IllegalArgumentException("input error (from)");
		}

		if (to == 'l') {
			target = left;
		} else if (to == 'm') {
			target = middle;
		} else if (to == 'r') {
			target = right;
		} else {
			throw new IllegalArgumentException("input error (to)");
		}

		int lastPieceFrom = source.get(source.size() - 1);
		int lastPieceTo= 0;

		if(target.isEmpty()) {
			lastPieceTo = 99;
		} else if(!target.isEmpty()) {
			lastPieceTo = target.get(target.size() - 1);
			System.out.println("lastPieceTo: " + lastPieceTo);
		}

		if (!source.isEmpty() && lastPieceTo > lastPieceFrom) {
			int onePiece = source.remove(source.size() - 1);
			target.add(onePiece);
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
		return left.iterator();
	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return middle.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return right.iterator();
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
