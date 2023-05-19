package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hanoi {
	static Queue<Integer> tower1 = new ArrayDeque<Integer>();
	static Queue<Integer> tower2 = new ArrayDeque<Integer>();
	static Queue<Integer> tower3 = new ArrayDeque<Integer>();
    static List<Integer> list1 = new LinkedList<Integer>();
    static List<Integer> list2 = new LinkedList<Integer>();
    static List<Integer> list3 = new LinkedList<Integer>();
	
	public Hanoi() {
		// TODO: Implement
		for(int i = 1; i <= 9; i++) {
		tower1.add(i);
		list1.add(i);
		}
	}
	
	private void movePiece(char from, char to) {
		if(from == to) {
			System.out.println("Sie müssen zwei unterschiedliche Tower eingeben.");
		}
		// TODO: Implement
		if(from == 'l') {
			if(to == 'm') {
				int i = tower1.remove();
				try {
				if(i < tower2.element()) {
					tower2.add(i);
				}else {
					System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
				}
				}catch(Exception e){
					tower2.add(i);
				}
				
			}else if (to == 'r'){
				int i = tower1.remove();
				try {
				if(i < tower3.element()) {
					tower3.add(i);
				}else {
					System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
				}
				}catch(Exception e){
					tower3.add(i);
				}
			}else {
				System.out.println("Keine gültige Eingabe!");
			}
		}else if(from == 'm'){
			
			if(to == 'l') {
				int i = tower2.remove();
				try {
					if(i < tower1.element()) {
						tower1.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
					}
					}catch(Exception e){
						tower1.add(i);
					}
			}else if (to == 'r'){
				int i = tower2.remove();
				try {
					if(i < tower3.element()) {
						tower3.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
					}
					}catch(Exception e){
						tower3.add(i);
					}
			}else {
				System.out.println("Keine gültige Eingabe!");
			}
			
		}else if (from == 'r') {
			if(to == 'l') {
				int i = tower3.remove();
				try {
					if(i < tower1.element()) {
						tower1.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
					}
					}catch(Exception e){
						tower1.add(i);
					}
			}else if (to == 'm') {
				int i = tower3.remove();
				try {
					if(i < tower2.element()) {
						tower2.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
					}
					}catch(Exception e){
						tower2.add(i);
					}
			}else {
				System.out.println("Keine gültige Eingabe!");
			}
			
		}else {
			System.out.println("Keine gültige Eingabe!");
		}
        
	}
	
	public int[] reverse(Collection<Integer>  c, Collection<Integer>  c1, Collection<Integer> c2) {
		Object[] testArray = c.toArray();
		Object[] testArray2 = c1.toArray();
		Object[] testArray3 = c2.toArray();
		int erstes = 0;
		int zweites = 0;
		int drittes = 0;
		
		if(testArray.length != 0) {
			 erstes = (int) testArray[testArray.length-1];
		}else {
			 erstes = 0;
		}
		
		if(testArray2.length != 0) {
			 zweites = (int) testArray2[testArray2.length-1];
		}else {
			 zweites = 0;
		}
		
		if(testArray3.length != 0) {
			 drittes = (int) testArray3[testArray3.length-1];
		}else {
			 drittes = 0;
		}

	    int[] lastArray = {erstes, zweites, drittes};
		return lastArray;
		
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
		return tower1.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return tower2.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return tower3.iterator();
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
//		int[] test =  hanoi.last(tower1, tower2, tower3);	
		hanoi.run();
	}

}
