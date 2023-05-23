package idh.java;

import java.io.BufferedReader;
import java.util.Stack;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Hanoi {
	
	public Stack<Integer> stackL;
	public Stack<Integer> stackM;
	public Stack<Integer> stackR;

	public Hanoi() {
		// TODO: Implement
		this.stackL = new Stack<Integer>();
		stackL.add(9);
		stackL.add(8);
		stackL.add(7);
		stackL.add(6);
		stackL.add(5);
		stackL.add(4);
		stackL.add(3);
		stackL.add(2);
		stackL.add(1);
		this.stackM = new Stack<Integer>();
		this.stackR = new Stack<Integer>();	
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		if(from == 'l') {
			if(to == 'm') {
				stackM.add(stackL.pop());
			}
			if(to == 'r') {
				stackR.add(stackL.pop());
			}
		} else if(from == 'm') {
			if(to == 'l') {
				stackL.add(stackM.pop());
			}
			if(to == 'r') {
				stackR.add(stackM.pop());
			}
		} else if(from == 'r') {
			if(to == 'm') {
				stackM.add(stackR.pop());
			}
			if(to == 'L') {
				stackL.add(stackR.pop());
			}
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
		public boolean hasNext() {
			return this.stackL.empty();
		}
	
		public int next(){
			return this.stackL.peek();
		}
		
		public void remove() {
			this.stackL.pop();
		}
	}
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		public boolean hasNext() {
			return this.stackM.empty();
		}
	
		public int next(){
			return this.stackM.peek();
		}
		
		public void remove() {
			this.stackM.pop();
		}
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		public boolean hasNext() {
			return this.stackR.empty();
		}
	
		public int next(){
			return this.stackR.peek();
		}
		
		public void remove() {
			this.stackR.pop();
		}
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
