package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

public class Hanoi {
	static ArrayDeque<Integer> tower1 = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> tower2 = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> tower3 = new ArrayDeque<Integer>();
	
	public Hanoi() {
		// TODO: Implement
		for(int i = 9; i > 0; i--) {
		tower1.add(i);
		}
	}
	
	private void movePiece(char from, char to) {
		if(from == to) {
			System.out.println("Sie müssen zwei unterschiedliche Tower eingeben.");
		}
		int i;
		// TODO: Implement
		if(from == 'l') {
			if(to == 'm') {
				
				try {
				i = tower1.removeLast();
				}catch(Exception e) {
					i = 0;
					System.out.println("Dieser Turm ist leer.");
				}
				try {
				if(i != 0 && i < tower2.peekLast()) {
					tower2.add(i);
				}else {
					System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
					tower1.addLast(i);

				}
				}catch(Exception e){
					tower2.add(i);
				}
				
			}else if (to == 'r'){
				try {
				i = tower1.removeLast();
				}catch(Exception e) {
					i = 0;
					System.out.println("Dieser Turm ist leer.");
				}
				try {
				if(i != 0 && i < tower3.peekLast()) {
					tower3.add(i);
				}else {
					System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
					tower1.addLast(i);
				}
				}catch(Exception e){
					tower3.add(i);
				}
			}else {
				System.out.println("Keine gültige Eingabe!");
			}
		}else if(from == 'm'){
			
			if(to == 'l') {
				try {
				i = tower2.removeLast();
				}catch(Exception e) {
					i = 0;
					System.out.println("Dieser Turm ist leer.");
				}
				try {
					if(i != 0 && i < tower1.peekLast()) {
						tower1.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
						tower2.addLast(i);
						
					}
					}catch(Exception e){
						tower1.add(i);
					}
			}else if (to == 'r'){
				try {
				i = tower2.removeLast();
				}catch(Exception e) {
					i = 0;
					System.out.println("Dieser Turm ist leer.");
				}
				try {
					if(i != 0 && i < tower3.peekLast()) {
						tower3.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
						tower2.addLast(i);
						
					}
					}catch(Exception e){
						tower3.add(i);
					}
			}else {
				System.out.println("Keine gültige Eingabe!");
			}
			
		}else if (from == 'r') {
			if(to == 'l') {
				try {
				i = tower3.removeLast();
				}catch(Exception e) {
					i = 0;
					System.out.println("Dieser Turm ist leer.");
				}
				try {
					if(i != 0 && i < tower1.peekLast()) {
						tower1.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
						tower3.addLast(i);
						
					}
					}catch(Exception e){
						tower1.add(i);
					}
			}else if (to == 'm') {
				try {
				i = tower3.removeLast();
				}catch(Exception e) {
					i = 0;
					System.out.println("Dieser Turm ist leer.");
				}
				try {
					if(i != 0 && i < tower2.peekLast()) {
						tower2.add(i);
					}else {
						System.out.println("Dieses Element ist größer als das oberste Element dieses Towers");
						tower3.addLast(i);
						
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
        i = 0;
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
