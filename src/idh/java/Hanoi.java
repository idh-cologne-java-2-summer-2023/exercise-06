package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Hanoi {
		
	
	class ObjectIterator<Object> implements Iterator<Object> {

		int pos = -1;
		
		@Override
		public boolean hasNext() {
			return lTower.size;
		}

		@Override
		public Object next() {
			pos ++;
			return get(pos);
		}
		
	}
	
	public Hanoi() {
		Queue<Integer> lTower = new LinkedList<Integer>();
		Queue<Integer> mTower = new LinkedList<Integer>();
		Queue<Integer> rTower = new LinkedList<Integer>();
		lTower.add(1);
		lTower.add(2);
		lTower.add(3);
		lTower.add(4);
		lTower.add(5);
		lTower.add(6);
		lTower.add(7);
		lTower.add(8);
		lTower.add(9);
		System.out.println("|");
		System.out.println(lTower);
		System.out.println("|");
		System.out.println(mTower);
		System.out.println("|");
		System.out.println(rTower);
		System.out.println("|");
	}
	
	private void movePiece(char from, char to) {
		// Can't add linked list to funtion 
		Hanoi.lTower();
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
		return Iterator <Integer> l = lTower.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
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
	//	hanoi.run();
		
	}

}

