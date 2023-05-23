package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {

	private Stack<Integer> leftStack;
	private Stack<Integer> middleStack;
	private Stack<Integer> rightStack;

	public Hanoi() {
		leftStack = new Stack<>();
		middleStack = new Stack<>();
		rightStack = new Stack<>();

		for (int i = 9; i >= 1; i--) {
			leftStack.push(i);
		}
	}

	private void movePiece(char from, char to) {
		// TODO: Implement
		Stack<Integer> sourceStack = getStack(from);
		Stack<Integer> targetStack = getStack(to);
		
		if(sourceStack.isEmpty()) {
			System.out.println("The source stack is empty.");
			return;
		}
		if (!targetStack.isEmpty() && sourceStack.peek() > targetStack.peek()) {
			System.out.println("Bigger disks can't be put on smaller ones.");
			return;
		}
		int disk = sourceStack.pop();
		targetStack.push(disk);
	}
	
	private Stack<Integer> getStack(char stack) {
		if(stack == 'l') {
				return leftStack;
		} else if (stack == 'm') {
			return middleStack;
		} else if(stack == 'r') {
			return rightStack;
		} else {
			throw new IllegalArgumentException("Invalid Stack " + stack);
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
		return leftStack.iterator();
	}
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement	
		return middleStack.iterator();
	}
	
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return rightStack.iterator();
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
