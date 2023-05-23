package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;

public class Hanoi {

    private Deque<Integer> left;
    private Deque<Integer> middle;
    private Deque<Integer> right;

	
	
	public Hanoi() {
        left = new ArrayDeque<>();
        middle = new ArrayDeque<>();
        right = new ArrayDeque<>();

        // Initialize the left tower with disks of sizes 9 to 1
        for (int i = 9; i >= 1; i--) {
            left.push(i);
        }
	}
	
    private void movePiece(char from, char to) {
        Deque<Integer> source = null;
        Deque<Integer> target = null;

        switch (from) {
            case 'l':
                source = left;
                break;
            case 'm':
                source = middle;
                break;
            case 'r':
                source = right;
                break;

        }

        switch (to) {
            case 'l':
                target = left;
                break;
            case 'm':
                target = middle;
                break;
            case 'r':
                target = right;
                break;
          
        }

        // Überprüfen, ob der Zug gültig ist
        if (source.isEmpty()) {
            System.out.println("Quelle ist leer. Ungültiger Zug.");
            return;
        }

        if (!target.isEmpty() && source.peek() > target.peek()) {
            System.out.println("Untere Scheibe kleiner. Ungültiger Zug.");
            return;
        }

        int disk = source.pop();
        target.push(disk);
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
	
    public Iterator<Integer> getLeftDescendingIterator() {
        return left.descendingIterator();
    }

    public Iterator<Integer> getMiddleDescendingIterator() {
        return middle.descendingIterator();
    }

    public Iterator<Integer> getRightDescendingIterator() {
        return right.descendingIterator();
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
