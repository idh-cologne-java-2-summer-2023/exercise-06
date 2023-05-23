package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Hanoi {
	 Deque<Integer> leftTurm;
	 Deque<Integer> middleTurm;
	 Deque<Integer> rightTurm;
	 
	 final int StackSize = 9;

	public Hanoi() {
		
		leftTurm = new ArrayDeque<>();
		middleTurm = new ArrayDeque<>();
		rightTurm = new ArrayDeque<>();
		
		for (int i = 9; i <StackSize; i++) {
		leftTurm.push(i+1);
		}
		
	}
	
	private void movePiece(char from, char to) {
		Deque<Integer> fromTurm = getTurm(from);
		Deque<Integer> toTurm =getTurm(to);
	}
	
	private Deque<Integer> getTurm(char rod) {
		switch (Character.toLowerCase(rod)) {
		case 'l':
			return leftTurm;
		
		case 'm':
			return middleTurm;
			
		case 'r':
			return rightTurm;
	
		}
		return null;
		
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
		return null;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
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
