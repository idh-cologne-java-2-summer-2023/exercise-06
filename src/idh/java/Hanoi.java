package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {

    private Stack<Integer> leftStack;
    private Stack<Integer> middleStack;
    private Stack<Integer> rightStack;

    public Hanoi() {
        leftStack = new Stack<>();
        middleStack = new Stack<>();
        rightStack = new Stack<>();

        // Scheiben der Größen 9 bis 1 auf dem linken Stab platzieren
        for (int i = 9; i >= 1; i--) {
            leftStack.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Stack<Integer> sourceStack = getStackFromChar(from);
        Stack<Integer> targetStack = getStackFromChar(to);

        if (sourceStack.isEmpty()) {
            System.out.println("Source stack is empty. Try again.");
            return;
        }

        if (!targetStack.isEmpty() && sourceStack.peek() > targetStack.peek()) {
            System.out.println("Invalid move. Cannot place a larger disk on top of a smaller one.");
            return;
        }

        int disk = sourceStack.pop();
        targetStack.push(disk);
    }

    private Stack<Integer> getStackFromChar(char c) {
        if (c == 'l') {
            return leftStack;
        } else if (c == 'm') {
            return middleStack;
        } else if (c == 'r') {
            return rightStack;
        }
        return null;
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
                } else {
                    System.out.println("Invalid input. Please enter two valid stick characters (l, m, r).");
                }
            } catch (Exception e) {
                System.out.println("Try again, something's not right.");
                // e.printStackTrace();
            }
        }
    }

    private Iterator<Integer> getDescendingIterator(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.addAll(stack);
        Stack<Integer> descendingStack = new Stack<>();

        while (!tempStack.isEmpty()) {
            descendingStack.push(tempStack.pop());
        }

        return descendingStack.iterator();
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
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n m|");
        iter = this.getMiddleDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n r|");
        iter = this.getRightDescendingIterator();
        while (iter.hasNext()) {
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
