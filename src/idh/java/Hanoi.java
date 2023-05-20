package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		
	}

	private void movePiece(char from, char to) {
		Tower source = getTower(from);
		Tower goal = getTower(to);
		listToStack(source.list, source.stack);
		listToStack(goal.list, goal.stack);
		if(goal.stack.isEmpty()
				|| source.stack.peek() < goal.stack.peek()) {
			goal.stack.add(source.stack.pop());
		} else System.out.println("Invalid Position.");
		stackToList(goal.stack, goal.list);
		stackToList(source.stack, source.list);
	}
	
	private Tower getTower(char position) {
		if(position == left.position) {
			return left;
		} else if(position == middle.position) {
			return middle;
		} else if(position == right.position) {
			return right;
		} return null;
	}

	private static void listToStack(LinkedList<Integer> list, Stack<Integer> stack) {
		for(int i = 0; i < list.size(); i++) {
			stack.add(list.get(i));
		}
	}
	
	private static void stackToList(Stack<Integer> stack, LinkedList<Integer> list) {
		list.clear();
		int length = stack.size();
		int[] tempArray = new int[length];
		for(int i = 0; i < length; i++) {
			tempArray[i] = stack.pop();
		}
		for(int i = length-1; i >= 0; i--) {
			list.add(tempArray[i]);
		}
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			this.printTowers();
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
	
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi(3);
			
		hanoi.run();
	}

}
