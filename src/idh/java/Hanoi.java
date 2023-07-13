package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Hanoi {

	private Queue<Integer> leftQueue;
	private Stack<Integer> leftStack;
	private Stack<Integer> middleStack;
	private Stack<Integer> rightStack;

	public Hanoi() {
		leftQueue = new LinkedList<>();
		leftStack = new Stack<>();
		middleStack = new Stack<>();
		rightStack = new Stack<>();

		// Scheiben der Größen 9 bis 1 auf dem linken Stab hinzufügen
		for (int i = 9; i >= 1; i--) {
			leftQueue.add(i);
			leftStack.push(i);
		}
	}

	private void movePiece(char from, char to) {
		Stack<Integer> sourceStack = getStackByChar(from);
		Stack<Integer> targetStack = getStackByChar(to);

		if (!sourceStack.isEmpty() && (targetStack.isEmpty() || sourceStack.peek() < targetStack.peek())) {
			int piece = sourceStack.pop();
			targetStack.push(piece);
		}
	}

	private Stack<Integer> getStackByChar(char c) {
		switch (c) {
			case 'l':
				return leftStack;
			case 'm':
				return middleStack;
			case 'r':
				return rightStack;
			default:
				throw new IllegalArgumentException("Invalid stack character: " + c);
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

	private Iterator<Integer> getDescendingIterator(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		tempStack.addAll(stack);
		return tempStack.iterator();
	}

	private Iterator<Integer> getLeftDescendingIterator() {
		return getDescendingIterator(leftStack);
	}

	private Iterator<Integer> getMiddleDescendingIterator() {
		return getDescendingIterator(middleStack);
	}

	private Iterator<Integer> getRightDescendingIterator() {
		return getDescendingIterator(rightStack);
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
