package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Hanoi {
	private Queue<Integer> leftPeg;
    private Stack<Integer> middlePeg;
    private Stack<Integer> rightPeg;    
	

	public Hanoi() {
		// TODO: Implement
		 leftPeg = new LinkedList<>();
	        middlePeg = new Stack<>();
	        rightPeg = new Stack<>();

	        for (int i = 9; i >= 1; i--) {
	            leftPeg.add(i);
	        }
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		private void movePiece(char from, char to) {
	        Stack<Integer> fromPeg = getPeg(from);
	        Stack<Integer> toPeg = getPeg(to);

	        if (fromPeg != null && toPeg != null && !fromPeg.isEmpty()) {
	            int disk = fromPeg.pop();
	            if (toPeg.isEmpty() || disk < toPeg.peek()) {
	                toPeg.push(disk);
	            } else {
	                System.out.println("Invalid move. Cannot place a larger disk on top of a smaller disk.");
	                fromPeg.push(disk);
	            }
	        } else {
	            System.out.println("Invalid move. Check the source and target pegs.");
	        }
		}
		
	    private Stack<Integer> getPeg(char peg) {
	        if (peg == 'l') {
	            return leftPeg;
	        } else if (peg == 'm') {
	            return middlePeg;
	        } else if (peg == 'r') {
	            return rightPeg;
	        } else {
	            return null;
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
		return leftPeg.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return middlePeg.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		Stack<Integer> temp = new Stack<>();
        temp.addAll(rightPeg);
        return temp.iterator();
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
