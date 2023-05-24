package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	Stack<Integer> leftTower = new Stack<Integer>();
	Stack<Integer> midTower = new Stack<Integer>();
	Stack<Integer> rightTower = new Stack<Integer>();

	public Hanoi() {
		for (int i = 9; i > 0; i--) {
			leftTower.push(i);
		}
	}
	
	private void movePiece(char from, char to) {	
		Stack<Integer> fromStack = getStackFromChar(from);
        Stack<Integer> toStack = getStackFromChar(to);

        if (!fromStack.isEmpty() && (toStack.isEmpty() || fromStack.peek() < toStack.peek())) {
            int number = fromStack.pop();
            toStack.push(number);
        } else {
            System.out.println("Invalid move!");
        }
	}
	 private Stack<Integer> getStackFromChar(char c) {
	        switch (c) {
	            case 'l':
	                return leftTower;
	            case 'm':
	                return midTower;
	            case 'r':
	                return rightTower;
	            default:
	                throw new IllegalArgumentException("Invlaid argument " + c);
	                }
	        }

	public boolean checkEmpty(char to) {
		switch (to) {
		case 'l': {
			return leftTower.empty();
		}
		case 'm': {
			return midTower.empty();
		}
		case 'r': {
			return rightTower.empty();
		}
		}
		return false;
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target stick:");
				String s = br.readLine();
				if (s.matches("^([lmr])([lmr])$")) {
					char source = s.charAt(0);
					char target = s.charAt(1);
					movePiece(source, target);
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
			} 
		}
	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
	
		return leftTower.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		
		return midTower.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		
		return rightTower.iterator();
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
		System.out.println("The rules are as following: \n"
				+ "1. Only one disk may be moved at a time.\n"
				+ "2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.\n"
				+ "3. No disk may be placed on top of a disk that is smaller than it. \n"
				+ "Good luck and have fun!");
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}
