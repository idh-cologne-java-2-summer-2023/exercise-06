package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Hier wurden Queue hinugefügt, um eine Eingabe für die verschiednen Stacks zu ermöglichen 
public class Hanoi {
    private Queue<Integer> leftStack;
    private Queue<Integer> middleStack;
    private Queue<Integer> rightStack;
    
    //Hier wurden die Stacks mit der LinkedList verbunden und eine Schleife hinzugefügt, um den linken Stab zu defninieren
	public Hanoi() {
		 leftStack = new LinkedList<>();
	        middleStack = new LinkedList<>();
	        rightStack = new LinkedList<>();

	        for (int i = 9; i >= 1; i--) {
	            leftStack.offer(i);
	        }
	}
	
	//Hier habe ich mit if-else gearbeitet, um zu definieren, was getan werden soll, wenn etwas eingegeben wird 
	private void movePiece(char from, char to) {
		Queue<Integer> sourceStack;
        Queue<Integer> targetStack;

        if (from == 'l') {
            sourceStack = leftStack;
        } else if (from == 'm') {
            sourceStack = middleStack;
        } else {
            sourceStack = rightStack;
        }

        if (to == 'l') {
            targetStack = leftStack;
        } else if (to == 'm') {
            targetStack = middleStack;
        } else {
            targetStack = rightStack;
        }
        Integer piece = sourceStack.poll();
        if (piece != null) {
            targetStack.offer(piece);
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
	
	//Hier werden Iteratoren zurückgegeben, die die Stacks durchlaufen und die gwünschte Methode liefern 
	private Iterator<Integer> getLeftDescendingIterator() {
		  return ((LinkedList<Integer>) leftStack).descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return ((LinkedList<Integer>) middleStack).descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		 return ((LinkedList<Integer>) rightStack).descendingIterator();
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
