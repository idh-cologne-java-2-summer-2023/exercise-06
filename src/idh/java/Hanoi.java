package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	Stack<Integer> left = new Stack<Integer>();
	Stack<Integer> middle = new Stack<Integer>();
	Stack<Integer> right = new Stack<Integer>();

	
	public Hanoi() {
		for (int i = 9; i > 0; i--) {
			left.push(i);
		}
	}
	
	private void movePiece(char from, char to) {
			int temp;
			if (from == 'l' && to =='m') {
				temp = left.pop();
				middle.push(temp);
			}
			if (from == 'l' && to =='r') {
				temp = left.pop();
				right.push(temp);
			}
			if (from == 'm' && to =='l') {
				temp = left.pop();
				left.push(temp);
			}
			if (from == 'm' && to =='r') {
				temp = left.pop();
				right.push(temp);
			}
			if (from == 'r' && to =='l') {
				temp = left.pop();
				left.push(temp);
			}
			if (from == 'r' && to =='m') {
				temp = left.pop();
				middle.push(temp);
			} else {
				System.out.println("no position.");
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
