package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	private LinkedList<Integer> leftStack;
	private LinkedList<Integer> middleStack;
	private LinkedList<Integer> rightStack;


	public Hanoi() {
		leftStack = new LinkedList<>();
		middleStack = new LinkedList<>();
		rightStack = new LinkedList<>();
	
		// Initialisierung: Scheiben von 9-1 auf linken Stab
		for (int size = 9; size >= 1; size--) {
			leftStack.add(size);
		}
	}
	
	
	
	private void movePiece(char from, char to) {
		LinkedList<Integer> sourceStack;
		LinkedList<Integer> targetStack;
		
		
		// Quellstab auswählen
				switch (from) {
					case 'l':
						sourceStack = leftStack;
						break;
					case 'm':
						sourceStack = middleStack;
						break;
					case 'r':
						sourceStack = rightStack;
						break;
					default:
						System.out.println("Invalid source stick!");
						return;
				}
				// Zielstab auswählen
				switch (to) {
					case 'l':
						targetStack = leftStack;
						break;
					case 'm':
						targetStack = middleStack;
						break;
					case 'r':
						targetStack = rightStack;
						break;
					default:
						System.out.println("Invalid target stick!");
						return;
				}
				// Überprüfen, ob der Zug gültig ist (keine größere Scheibe auf kleinerer Scheibe)
				if (!targetStack.isEmpty() && sourceStack.peekLast() > targetStack.peekLast()) {
					System.out.println("Invalid move! Cannot place a larger piece on top of a smaller one.");
					return;
				}

				// Scheibe von der Quelle zum Ziel verschieben
				int piece = sourceStack.removeLast();
				targetStack.add(piece);
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
		// TODO: Implement
		return null;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return null;
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
