package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Hanoi {

	static ArrayDeque<Integer> towerLeft = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> towerMiddle = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> towerRight = new ArrayDeque<Integer>();
	
	public Hanoi() {
		for(int i = 9; i >= 1; i--) {
			towerLeft.add(i);
		}
	}
	
	private ArrayDeque<Integer> getTower(char t){
		switch (t) {
		default : return null;
		case 'l' : return towerLeft;
		case 'm' : return towerMiddle;
		case 'r' : return towerRight;
		}
	}
	
	private void movePiece(char from, char to) {
		ArrayDeque<Integer> sourceTower = getTower(from);
		ArrayDeque<Integer> targetTower = getTower(to);
		if (sourceTower.isEmpty()) {
			System.out.println("This tower is empty. Try another one.");
		}
		else if (!targetTower.isEmpty() && sourceTower.peekFirst() > targetTower.peekFirst()) {
			System.out.println("Cannot stack bigger piece");
		}
		else {
			targetTower.add(sourceTower.removeLast());
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
		return towerLeft.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return towerMiddle.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return towerRight.iterator();
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
