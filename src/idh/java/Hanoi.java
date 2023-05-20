package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Hanoi {
				
	Tower left;
	Tower middle;
	Tower right;
	
	int height;
	
	public Hanoi(int height) {
		this.height = height;
		
		this.left = new Tower('l');
		left.list = new LinkedList<Integer>();
		left.stack = new Stack<Integer>();
		
		this.middle = new Tower('m');
		middle.list = new LinkedList<Integer>();
		middle.stack = new Stack<Integer>();
		
		this.right = new Tower('r');
		right.list = new LinkedList<Integer>();
		right.stack = new Stack<Integer>();
		
		for(int i = height; i > 0; i--) {
			left.list.add(i);
		}
		
		listToStack(left.list, left.stack);

	}
	
	private void movePiece(char from, char to) {
		System.out.println("null");
		if(getTower(to).stack.isEmpty()
				|| getTower(from).stack.peek() < getTower(to).stack.peek()) {
			System.out.println("eins");
			getTower(to).stack.add(getTower(from).stack.pop());
		} else System.out.println("Invalid Position.");
		stackToList(getTower(to).stack, getTower(to).list);
		stackToList(getTower(from).stack, getTower(from).list);
	}
	
	private Tower getTower(char position) {
		System.out.println("a");
		if(position == left.position) {
			System.out.println("l");
			return left;
		} else if(position == middle.position) {
			System.out.println("m");
			return middle;
		} else if(position == right.position) {
			return right;
		} return null;
	}
	
//	private static void movePiece(char from, char to) {
//		System.out.println("null");
//		for(int i = 0; i <= 3; i++) {
//			System.out.println("a");
//			if (from == towers[i].position) {
//				System.out.println("eins");
//				for(int ii = 0; ii <= 3; ii++) {
//					if (towers[i].stack.peek() < towers[ii].stack.peek() 
//							|| towers[ii].stack.peek() == null) {
//						System.out.println("zwei");
//						towers[ii].stack.add(towers[i].stack.pop());
//					}
//				}
//			}
//		}
//	}
	
	private static void listToStack(LinkedList<Integer> list, Stack<Integer> stack) {
		for(int i = list.size(); i > 0; i--) {
			stack.add(list.get(i-1));
		}
	}
	
	private static void stackToList(Stack<Integer> stack, LinkedList<Integer> list) {
		for(int i = 0; i < stack.size(); i++) {
			list.set(i, stack.pop());
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
	
	public void printTowers() {
		this.left.printTower();
		this.middle.printTower();
		this.right.printTower();
		System.out.println(" |");
	}

	public class TowerIterator implements Iterator<Integer> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
//	private Iterator<Integer> getLeftDescendingIterator() {
//		// TODO: Implement
//		return null;
//
//	}
//	private Iterator<Integer> getMiddleDescendingIterator() {
//		// TODO: Implement
//		return null;
//
//	}
//	private Iterator<Integer> getRightDescendingIterator() {
//		// TODO: Implement
//		return null;
//	}
//	
//	public String toString() {
//		StringBuilder b = new StringBuilder();
//		b.append("  |\n l|");
//		Iterator<Integer> iter;
//		iter = this.getLeftDescendingIterator();
//		while(iter.hasNext()) {
//			b.append(iter.next());
//			b.append(' ');
//		}
//		b.append("\n  |\n m|");
//		iter = this.getMiddleDescendingIterator();
//		while(iter.hasNext()) {
//			b.append(iter.next());
//			b.append(' ');
//		}
//		b.append("\n  |\n r|");
//		iter = this.getRightDescendingIterator();
//		while(iter.hasNext()) {
//			b.append(iter.next());
//			b.append(' ');
//		}
//		b.append("\n  |");
//		return b.toString();
//	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi(3);
		
		System.out.println(hanoi.left.list);
		System.out.println(hanoi.left.list.peek());
		System.out.println(hanoi.left.stack);
		System.out.println(hanoi.left.stack.peek());
		stackToList(hanoi.left.stack, hanoi.left.list);
		System.out.println(hanoi.left.list);
		hanoi.printTowers();
		hanoi.movePiece('l', 'm');
		hanoi.printTowers();
//		System.out.println(hanoi.getTower('m').stack);
		
//		hanoi.run();
	}

}
