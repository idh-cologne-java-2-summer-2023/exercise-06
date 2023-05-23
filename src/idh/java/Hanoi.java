package idh.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	 private LinkedList<Integer> leftStack;
	    private LinkedList<Integer> middleStack;
	    private LinkedList<Integer> rightStack;

	public Hanoi() {
		leftStack = new LinkedList<>();
        middleStack = new LinkedList<>();
        rightStack = new LinkedList<>();

       
        for (int i = 9; i >= 1; i--) {
            leftStack.push(i);
        }
    }

	
	private void movePiece(char from, char to) {
		 LinkedList<Integer> sourceStack = getStackFromChar(from);
	        LinkedList<Integer> targetStack = getStackFromChar(to);

	        if (sourceStack.isEmpty()) {
	            System.out.println("Quelle ist leer. Ungültiger Zug.");
	            return;
	        }

	        if (!targetStack.isEmpty() && sourceStack.peek() > targetStack.peek()) {
	            System.out.println("Ungültiger Zug. Eine größere Scheibe darf nicht auf einer kleineren liegen.");
	            return;
	        }

	        int disk = sourceStack.pop();
	        targetStack.push(disk);
	    }

	    private LinkedList<Integer> getStackFromChar(char c) {
	        if (c == 'l') {
	            return leftStack;
	        } else if (c == 'm') {
	            return middleStack;
	        } else if (c == 'r') {
	            return rightStack;
	        } else {
	            throw new IllegalArgumentException("Ungültiger Stab: " + c);
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
	
	private Iterator<Integer> getDescendingIterator(LinkedList<Integer> stack) {
	        return stack.descendingIterator();
	    }
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return getDescendingIterator(leftStack);
	}
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		return getDescendingIterator(middleStack);
	}
	
	private Iterator<Integer> getRightDescendingIterator() {
		 return getDescendingIterator(rightStack);	
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
