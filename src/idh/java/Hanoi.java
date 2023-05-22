package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque; // resizable-array implementation of a double-ended queue
import java.util.Deque; // allows adding and removing elements from both ends
import java.util.Iterator;

public class Hanoi {

    private Deque<Integer> leftRod;
    private Deque<Integer> middleRod;
    private Deque<Integer> rightRod;

    public Hanoi() {
        leftRod = new ArrayDeque<>();
        middleRod = new ArrayDeque<>();
        rightRod = new ArrayDeque<>();

        // Initialize the left rod with discs of sizes 9 to 1
        for (int i = 9; i >= 1; i--) {
            leftRod.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Deque<Integer> sourceRod = getRod(from);
        Deque<Integer> targetRod = getRod(to);

        if (sourceRod.isEmpty()) {
            System.out.println("Source rod is empty.");
        } else if (!targetRod.isEmpty() && sourceRod.peek() > targetRod.peek()) {
            System.out.println("Cannot place a larger disc on top of a smaller one.");
        } else {
            int disc = sourceRod.pop();
            targetRod.push(disc);
        }
    }

    private Deque<Integer> getRod(char rod) {
        switch (Character.toLowerCase(rod)) {
            case 'l':
                return leftRod;
            case 'm':
                return middleRod;
            case 'r':
                return rightRod;
            default:
                throw new IllegalArgumentException("Invalid rod: " + rod);
        }
    }

    private Iterator<Integer> getDescendingIterator(Deque<Integer> rod) {
        return rod.descendingIterator();
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(this);
                System.out.print("Enter source and target rod (will move top disc): ");
                String s = br.readLine();
                if (s.matches("^([lmr])([lmr])$")) {
                    char source = s.charAt(0);
                    char target = s.charAt(1);
                    movePiece(source, target);
                } else {
                    System.out.println("Invalid input. Please enter a valid source and target rod.");
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
        Iterator<Integer> iter;
        iter = getDescendingIterator(leftRod);
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n m|");
        iter = getDescendingIterator(middleRod);
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n r|");
        iter = getDescendingIterator(rightRod);
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
