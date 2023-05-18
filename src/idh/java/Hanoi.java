package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	private Stack<Integer> sLeft = new Stack<>();
	private Stack<Integer> sMid = new Stack<>();
	private Stack<Integer> sRight = new Stack<>();
	
	
	public Hanoi() {
		for (int i = 9; i > 0; i--) {
			sLeft.push(i);
		}
	}
	
	private void execute(Stack<Integer> source, Stack<Integer> target) {
		if (!source.empty() && ((!target.empty() && target.lastElement() > source.lastElement()) || target.empty())) {
			int item = source.pop();
			target.push(item);
		}
	}

	private void movePiece(char from, char to) {
		switch (from) {
		case 'l':
			if (to == 'm')
				execute(sLeft, sMid);
			else execute(sLeft, sRight);
			break;
		case 'm':
			if (to == 'r')
				execute(sMid, sRight);
			else execute(sMid, sLeft);
			break;
		case 'r':
			if (to == 'l')
				execute(sRight, sLeft);
			else execute(sRight, sMid);
			break;
		}
	}
	

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this);
				if (sLeft.empty() && sMid.empty()) {
					System.out.println("Congrats, you nailed it!");
					System.exit(0);
				}
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
	
	// getters
	private Iterator<Integer> getLeftDescendingIterator() {
		return sLeft.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return sMid.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return sRight.iterator();
	}
	
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("\n  |\n l|");
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
