package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Hanoi {
    private Stack<Integer> leftStack;
    private Stack<Integer> middleStack;
    private Stack<Integer> rightStack;

    public Hanoi() {
        leftStack = new Stack<>();
        middleStack = new Stack<>();
        rightStack = new Stack<>();

        // Initialisierung der Scheiben auf dem linken Stab
        for (int i = 9; i >= 1; i--) {
            leftStack.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Stack<Integer> sourceStack = getStackFromChar(from);
        Stack<Integer> targetStack = getStackFromChar(to);

        if (!sourceStack.isEmpty() && (targetStack.isEmpty() || sourceStack.peek() < targetStack.peek())) {
            int piece = sourceStack.pop();
            targetStack.push(piece);
        } else {
            System.out.println("Ungültiger Zug!");
        }
    }

    private Stack<Integer> getStackFromChar(char c) {
        switch (c) {
            case 'l':
                return leftStack;
            case 'm':
                return middleStack;
            case 'r':
                return rightStack;
            default:
                throw new IllegalArgumentException("Ungültiger Stab: " + c);
        }
    }

    private Iterator<Integer> getDescendingIterator(Stack<Integer> stack) {
        final ListIterator<Integer> iterator = stack.listIterator(stack.size());
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasPrevious();
            }

            @Override
            public Integer next() {
                return iterator.previous();
            }
        };
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

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("  |\n l|");
        Iterator<Integer> iter = getDescendingIterator(leftStack);
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n m|");
        iter = getDescendingIterator(middleStack);
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n r|");
        iter = getDescendingIterator(rightStack);
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

