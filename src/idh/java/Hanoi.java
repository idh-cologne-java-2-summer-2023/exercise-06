package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	
	Deque<Integer> towerLeft = new LinkedList<Integer>();
	Deque<Integer> towerMiddle = new LinkedList<Integer>();
	Deque<Integer> towerRight = new LinkedList<Integer>();

	public Hanoi() {
		towerLeft.add(1);
		towerLeft.add(2);
		towerLeft.add(3);
		towerLeft.add(4);
		towerLeft.add(5);
		towerLeft.add(6);
		towerLeft.add(7);
		towerLeft.add(8);
		towerLeft.add(9);
		
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		int hold = 0;
		
		switch (from) {
		case 'l':
			hold = towerLeft.poll();
			break;
		case 'm':
			hold = towerMiddle.poll();
			break;
		case 'r':
			hold = towerRight.poll();
			break;
		default:
			break;
		}
		
		switch (to) {
		case 'l':
			if(towerLeft.peek() != null) {
				if (hold < towerLeft.peek()) {
					towerLeft.addFirst(hold);}
				else {
					System.out.println("Die Zahl darf nicht höher als die vorhandene sein.");
				switch (from) {
				case 'l':
					towerLeft.addFirst(hold);
					break;
				case 'm':
					towerMiddle.addFirst(hold);
					break;
				case 'r':
					towerRight.addFirst(hold);
					break;
				default:
					break;
				}
				}
			}
			else
				towerLeft.addFirst(hold);
			break;
		case 'm':
			if(towerMiddle.peek() != null) {
				if (hold < towerMiddle.peek()) {
					towerMiddle.addFirst(hold);}
				else { 
					System.out.println("Die Zahl darf nicht höher als die vorhandene sein.");
					switch (from) {
				case 'l':
					towerLeft.addFirst(hold);
					break;
				case 'm':
					towerMiddle.addFirst(hold);
					break;
				case 'r':
					towerRight.addFirst(hold);
					break;
				default:
					break;
					}
				}
				}
			else
				towerMiddle.addFirst(hold);
			break;
		case 'r':
			if(towerRight.peek() != null) {
				if (hold < towerRight.peek()) {
					towerRight.addFirst(hold);}
				else {
					System.out.println("Die Zahl darf nicht höher als die vorhandene sein.");
				switch (from) {
				case 'l':
					towerLeft.addFirst(hold);
					break;
				case 'm':
					towerMiddle.addFirst(hold);
					break;
				case 'r':
					towerRight.addFirst(hold);
					break;
				default:
					break;
				}
				}
				}
			else
				towerRight.addFirst(hold);
			break;
		default:
			break;
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
		// TODO: Implement
		return towerLeft.descendingIterator();
	}
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return towerMiddle.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return towerRight.descendingIterator();
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
