package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

public class Hanoi {
	
	static ArrayDeque<Integer> stabL = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> stabM = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> stabR = new ArrayDeque<Integer>();
	
	public Hanoi() {
		for(int i = 9; i > 0; i--) {
		stabL.add(i);
		}
	}
	
	private void movePiece(char from, char to) {
		if(from == to) {
				System.out.println("Try again, something's not right.");
		}
		int i;
		
		if(from == 'l') {
			if(to == 'm') {
				try {
				i = stabL.removeLast();
				}catch(Exception e) {
					i = 0;
				}
				try {
				if(i != 0 && i < stabM.peekLast()) {
					stabM.add(i);
				}else {
					stabL.addLast(i);

				}
				}catch(Exception e){
					stabM.add(i);
				}
				
			}else if (to == 'r'){
				try {
				i = stabL.removeLast();
				}catch(Exception e) {
					i = 0;
				}
				try {
				if(i != 0 && i < stabR.peekLast()) {
					stabR.add(i);
				}else {
					stabL.addLast(i);
				}
				}catch(Exception e){
					stabR.add(i);
				}
			}
		}else if(from == 'm'){
			
			if(to == 'l') {
				try {
				i = stabM.removeLast();
				}catch(Exception e) {
					i = 0;
				}
				try {
					if(i != 0 && i < stabL.peekLast()) {
						stabL.add(i);
					}else {
						stabM.addLast(i);
						
					}
					}catch(Exception e){
						stabL.add(i);
					}
			}else if (to == 'r'){
				try {
				i = stabM.removeLast();
				}catch(Exception e) {
					i = 0;
				}
				try {
					if(i != 0 && i < stabR.peekLast()) {
						stabR.add(i);
					}else {
						stabM.addLast(i);
						
					}
					}catch(Exception e){
						stabR.add(i);
					}
			}
			
		}else if (from == 'r') {
			if(to == 'l') {
				try {
				i = stabR.removeLast();
				}catch(Exception e) {
					i = 0;
				}
				try {
					if(i != 0 && i < stabL.peekLast()) {
						stabL.add(i);
					}else {
						stabR.addLast(i);
						
					}
					}catch(Exception e){
						stabL.add(i);
					}
			}else if (to == 'm') {
				try {
				i = stabR.removeLast();
				}catch(Exception e) {
					i = 0;
				}
				try {
					if(i != 0 && i < stabM.peekLast()) {
						stabM.add(i);
					}else {
						stabR.addLast(i);
						
					}
					}catch(Exception e){
						stabM.add(i);
					}
			}
		}
	}
	
	public int[] reverse(Collection<Integer>  c, Collection<Integer>  c1, Collection<Integer> c2) {
		Object[] testArray1 = c.toArray();
		Object[] testArray2 = c1.toArray();
		Object[] testArray3 = c2.toArray();
		int erstes = 0;
		int zweites = 0;
		int drittes = 0;
		
		if(testArray1.length != 0) {
			 erstes = (int) testArray1[testArray1.length-1];
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
		return stabL.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return stabM.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return stabR.iterator();
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