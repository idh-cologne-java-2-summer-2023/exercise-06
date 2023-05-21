package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;



public class Hanoi  {
	
	private final int Capacity = 9;
	
	public Hanoi(int Capacity) {
		
		Capacity = this.Capacity;
}
	
	
	
	private void movePiece(char from, char to) {
		
		switch (from) {
		
		case 1:
		from = 'l';
		
		switch (to) {
		
		case 10: 
		to = 'm';
		break;
		
		case 20:
		to = 'l';
		break;
		
		case 30:
		to = 'r';
		break;
		
		}
		break;
		
		case 2:
		from = 'm';
		break;
		
		case 3:
		from = 'r';
		break;
		
		
	}
	}
//couldn't figure out how to move from one deque to the other.
		
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				System.out.print("Enter source and target stick (will move top piece):");
				String userInput = br.readLine();
				if (userInput.matches("^([lmr])([lmr])$")) {
					char source = userInput.charAt(0);
					char target = userInput.charAt(1);
					movePiece(source, target);
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				// e.printStackTrace();
			} 
		}
	}
	
	
	
	
	
	public Iterator<Integer> getLeftDescendingIterator() {
		
		
		Deque<Integer> stackL = new ArrayDeque<>();
		stackL.add(9);
		stackL.add(8);
		stackL.add(7);
		stackL.add(6);
		stackL.add(5);
		stackL.add(4);
		stackL.add(3);
		stackL.add(2);
		stackL.add(1);
		
		
		
		return new Iterator() {
			
      
			int start = 0;
			
			@Override
			public boolean hasNext() {
				return start < stackL.size();
			}
		
			
			public Integer hasPrevious() {
				return stackL.pollFirst();
			} 
			
			
			@Override
			public Integer next() {
				return stackL.pollFirst();
			}	
		}; 
	} 
	
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		
		Deque<Integer> stackM = new ArrayDeque<>();

		
		return new Iterator() {
			
			int start = 0;
			
			@Override
			public boolean hasNext() {
				return start < stackM.size();
			}

			@Override
			public Object next() {
				return stackM.pollFirst();
			}
		}; 
	}
	
	
	
	private Iterator<Integer> getRightDescendingIterator() {
		
		Deque<Integer> stackR = new ArrayDeque<>();
		
		return new Iterator() {
			
			int start = 8;

			@Override
			public boolean hasNext() {
				return start < stackR.size();
			}

			@Override
			public Object next() {
				return stackR.pollFirst();
			}
		}; 
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
		Hanoi hanoi = new Hanoi(9);
		hanoi.run();  
	
		
		
	}

}
