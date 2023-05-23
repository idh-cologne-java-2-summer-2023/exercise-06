package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;

public class Hanoi {

	Deque<Integer> left;
    Deque<Integer> middle;
    Deque<Integer> right;

    public Hanoi() {
        initializeStacks();
    }
	
	private void initializeStacks() {
		left = new ArrayDeque<>();
		middle = new ArrayDeque<>();
		right = new ArrayDeque<>();
        for (int i = 9; i >= 1; i--) {
            left.push(i);
        }
    }

	private void movePiece(char from, char to) {
		Deque<Integer> sourceStack = getStackByChar(from);
        Deque<Integer> targetStack = getStackByChar(to);
        if (sourceStack != null && targetStack != null && sourceStack != targetStack) {
            if (isMoveValid(sourceStack, targetStack)) {
                int pieceToMove = sourceStack.pop();
                targetStack.push(pieceToMove);
            } else {
                System.out.println("Invalid move! Cannot place a larger disk on top of a smaller one.");
            }
        } else {
            System.out.println("Invalid move! Make sure you entered valid source and target sticks.");
        }
	}
	
	private Deque<Integer> getStackByChar(char c) {
        if (c == 'l') {
            return left;
        } else if (c == 'm') {
            return middle;
        } else if (c == 'r') {
            return right;
        }
        return null;
    }

    private boolean isMoveValid(Deque<Integer> source, Deque<Integer> target) {
        return target.isEmpty() || source.peek() < target.peek();
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
	
	  private Iterator<Integer> getDescendingIterator(Deque<Integer> stack) {
	        return stack.descendingIterator();
	    }

    private Iterator<Integer> getLeftDescendingIterator() {
        return getDescendingIterator(left);
    }

    private Iterator<Integer> getMiddleDescendingIterator() {
        return getDescendingIterator(middle);
    }

    private Iterator<Integer> getRightDescendingIterator() {
        return getDescendingIterator(right);
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

