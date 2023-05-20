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
		System.out.print(this.position + "|"); 
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i) != 0) {
			System.out.print(this.list.get(i) + " ");	
			}
		}
		System.out.println();
	}

}
