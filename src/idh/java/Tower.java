package idh.java;

import java.util.LinkedList;
import java.util.Stack;

public class Tower {
	
	char position;
	
	LinkedList<Integer> list;
	
	Stack<Integer> stack;
	
	public Tower(char position) {
		this.position = position;
	}
	
	public void printTower() {
		System.out.println(" |");
		System.out.println(this.position + "|" + this.list);
	}

}
