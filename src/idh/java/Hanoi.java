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

        // Initialize leftStack with disks of sizes 9 to 1
        for (int i = 9; i >= 1; i--) {
            leftStack.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Stack<Integer> sourceStack = getStackFromChar(from);
        Stack<Integer> targetStack = getStackFromChar(to);

        if (!sourceStack.isEmpty() && (targetStack.isEmpty() || sourceStack.peek() < targetStack.peek())) {
            int disk = sourceStack.pop();
            targetStack.push(disk);
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    private Stack<Integer> getStackFromChar(char c) {
        if (c == 'l') {
            return leftStack;
        } else if (c == 'm') {
            return middleStack;
        } else if (c == 'r') {
            return rightStack;
        } else {
            throw new IllegalArgumentException("Invalid stack identifier: " + c);
        }
    }

    private Iterator<Integer> getDescendingIterator(Stack<Integer> stack) {
        return stack.iterator();
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(this);
                System.out.print("Enter source and target stick (will move top piece): ");
                String input = br.readLine();
                if (input.matches("^([lmr])([lmr])$")) {
                    char source = input.charAt(0);
                    char target = input.charAt(1);
                    movePiece(source, target);
                } else {
                    System.out.println("Invalid input! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Try again, something's not right.");
                // e.printStackTrace();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  |\n l|");
        Iterator<Integer> iter = getDescendingIterator(leftStack);
        while (iter.hasNext()) {
            sb.append(iter.next());
            sb.append(' ');
        }
        sb.append("\n  |\n m|");
        iter = getDescendingIterator(middleStack);
        while (iter.hasNext()) {
            sb.append(iter.next());
            sb.append(' ');
        }
        sb.append("\n  |\n r|");
        iter = getDescendingIterator(rightStack);
        while (iter.hasNext()) {
            sb.append(iter.next());
            sb.append(' ');
        }
        sb.append("\n  |");
        return sb.toString();
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.run();
    }
}