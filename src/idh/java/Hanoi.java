package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Hanoi {
    private Queue<Integer> leftStack;     // Stab l
    private Queue<Integer> middleStack;   // Stab m
    private Queue<Integer> rightStack;    // Stab r

    public Hanoi() {
        leftStack = new LinkedList<>();
        middleStack = new LinkedList<>();
        rightStack = new LinkedList<>();

        // Scheiben der Größen 9 bis 1 auf dem linken Stab platzieren
        for (int i = 9; i >= 1; i--) {
            leftStack.offer(i);
        }
    }

    private void movePiece(char from, char to) {
        Queue<Integer> fromStack = getStackForChar(from);
        Queue<Integer> toStack = getStackForChar(to);

        if (fromStack == null || toStack == null) {
            System.out.println("Ungültige Eingabe. Bitte Quell- und Zielstab angeben.");
            return;
        }

        if (fromStack.isEmpty()) {
            System.out.println("Der Quellstab ist leer. Es gibt keine Scheibe zum Bewegen.");
            return;
        }

        if (!toStack.isEmpty() && fromStack.peek() > toStack.peek()) {
            System.out.println("Ungültiger Zug. Eine größere Scheibe kann nicht auf eine kleinere Scheibe gelegt werden.");
            return;
        }

        int disk = fromStack.poll();
        toStack.offer(disk);
    }

    private Queue<Integer> getStackForChar(char c) {
        if (c == 'l') {
            return leftStack;
        } else if (c == 'm') {
            return middleStack;
        } else if (c == 'r') {
            return rightStack;
        } else {
            return null;
        }
    }

    private Iterator<Integer> getDescendingIterator(Queue<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        Iterator<Integer> iterator = stack.iterator();

        while (iterator.hasNext()) {
            tempStack.push(iterator.next());
        }

        return tempStack.iterator();
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(this);
                System.out.print("Geben Sie Quell- und Zielstab an (obere Scheibe wird verschoben): ");
                String input = br.readLine();
                if (input.matches("^([lmr])([lmr])$")) {
                    char source = input.charAt(0);
                    char target = input.charAt(1);
                    movePiece(source, target);
                } else {
                    System.out.println("Ungültige Eingabe. Bitte Quell- und Zielstab angeben (z.B. lm).");
                }
            } catch (Exception e) {
                System.out.println("Ein Fehler ist aufgetreten. Bitte versuchen Sie es erneut.");
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