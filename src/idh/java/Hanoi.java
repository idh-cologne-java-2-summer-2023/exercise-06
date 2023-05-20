package idh.java;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;

public class Hanoi {
	Deque<Integer> l = new ArrayDeque<Integer>();
	Deque<Integer> m = new ArrayDeque<Integer>();
	Deque<Integer> r = new ArrayDeque<Integer>();

	public Hanoi(int pieceAmount) {
		if(pieceAmount < 1 )
			pieceAmount = 1;
		else if(pieceAmount > 9)
			pieceAmount = 9;
		
		for(;pieceAmount>0; pieceAmount--) {
			l.push(pieceAmount);
		}
	}
	
	private void movePiece(char from, char to) {
		Deque<Integer> popStack = whichStack(from);
		Deque<Integer> pushStack = whichStack(to);
		
		if(pushStack.isEmpty() ||popStack.getFirst() < pushStack.getFirst())
			pushStack.push(popStack.pop());
		else
			System.out.println("Move not possible, the moved piece is bigger than the top of the destination-stack.");
	}
	
	private Deque<Integer> whichStack(char c) {
		switch (c) {
			case 'l': {
				return this.l;
			}
			case 'm': {
				return this.m;
			}
			case 'r': {
				return this.r;
			}
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
				// e.printDequeTrace();
			} 
		}
	}
	
//	private Deque<Integer> reverseDeque(Deque<Integer> stack){
//		Deque<Integer> temp = new ArrayDeque<Integer>();
//		for(Integer i : stack) {
//			temp.push(i);
//		}
//		return temp;
//	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return l.descendingIterator();
	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return m.descendingIterator();
	}
	private Iterator<Integer> getRightDescendingIterator() {
		return r.descendingIterator();
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
		Hanoi hanoi = new Hanoi(9);
		hanoi.run();
	}

}
