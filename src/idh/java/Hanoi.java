package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Hanoi {

    private Deque<Integer> leftStack;
    private Deque<Integer> middleStack;
    private Deque<Integer> rightStack;

    public Hanoi() {
        leftStack = new ArrayDeque<>();
        middleStack = new ArrayDeque<>();
        rightStack = new ArrayDeque<>();

        // Scheiben der Größe 9 bis 1 auf dem linken Stab platzieren
        for (int i = 9; i >= 1; i--) {
            leftStack.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Deque<Integer> sourceStack = getStackByChar(from);
        Deque<Integer> targetStack = getStackByChar(to);

        if (sourceStack.isEmpty()) {
            System.out.println("Invalid move: Source stack is empty.");
            return;
        }

        if (!targetStack.isEmpty() && sourceStack.peek() > targetStack.peek()) {
            System.out.println("Invalid move: Cannot place a larger disc on top of a smaller one.");
            return;
        }

        int disc = sourceStack.pop();
        targetStack.push(disc);
    }

    private Deque<Integer> getStackByChar(char c) {
        switch (c) {
            case 'l':
                return leftStack;
            case 'm':
                return middleStack;
            case 'r':
                return rightStack;
            default:
                throw new IllegalArgumentException("Invalid stack identifier: " + c);
        }
    }

    private Iterator<Integer> getDescendingIterator(Deque<Integer> stack) {
        return stack.descendingIterator();
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

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(this);
                System.out.print("Enter source and target stack (will move top disc): ");
                String s = br.readLine();
                if (s.matches("^([lmr])([lmr])$")) {
                    char source = s.charAt(0);
                    char target = s.charAt(1);
                    movePiece(source, target);
                }
            } catch (Exception e) {
                System.out.println("Try again, something's not right.");
            }
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.run();
    }
}
