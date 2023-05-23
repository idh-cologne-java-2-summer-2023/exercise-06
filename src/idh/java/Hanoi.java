package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Hanoi {
    private Queue<Integer> leftQueue;
    private Stack<Integer> middleStack;
    private Queue<Integer> rightQueue;

    public Hanoi() {
        leftQueue = new LinkedList<>();
        middleStack = new Stack<>();
        rightQueue = new LinkedList<>();

        // Scheiben der Größe 9 bis 1 auf dem linken Stab platzieren
        for (int i = 9; i >= 1; i--) {
            leftQueue.add(i);
        }
    }

    private void movePiece(char from, char to) {
        Queue<Integer> source = getQueueByLabel(from);
        Queue<Integer> target = getQueueByLabel(to);

        if (!source.isEmpty() && (target.isEmpty() || source.peek() < target.peek())) {
            int disk = source.poll();
            target.add(disk);
        } else {
            System.out.println("Ungültiger Zug! Versuchen Sie es erneut.");
        }
    }

    private Queue<Integer> getQueueByLabel(char label) {
        switch (label) {
            case 'l':
                return leftQueue;
            case 'm':
                return middleStackToQueue();
            case 'r':
                return rightQueue;
            default:
                throw new IllegalArgumentException("Ungültiger Stab: " + label);
        }
    }

    private Queue<Integer> middleStackToQueue() {
        Queue<Integer> tempQueue = new LinkedList<>();
        Stack<Integer> tempStack = new Stack<>();

        while (!middleStack.isEmpty()) {
            tempStack.push(middleStack.pop());
        }

        while (!tempStack.isEmpty()) {
            int disk = tempStack.pop();
            tempQueue.add(disk);
            middleStack.push(disk);
        }

        return tempQueue;
    }

    private Iterator<Integer> getLeftDescendingIterator() {
        List<Integer> list = new ArrayList<>(leftQueue);
        Collections.reverse(list);
        return list.iterator();
    }

    private Iterator<Integer> getMiddleDescendingIterator() {
        List<Integer> list = new ArrayList<>(middleStack);
        Collections.reverse(list);
        return list.iterator();
    }

    private Iterator<Integer> getRightDescendingIterator() {
        List<Integer> list = new ArrayList<>(rightQueue);
        Collections.reverse(list);
        return list.iterator();
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("  |\n l|");
        Iterator<Integer> iter = getLeftDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n m|");
        iter = getMiddleDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n r|");
        iter = getRightDescendingIterator();
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
                System.out.print("Geben Sie den Quell- und Zielstab ein (z.B. lm für 'Nimm die oberste Scheibe vom linken Stab und lege sie auf den mittleren'): ");
                String s = br.readLine();
                if (s.matches("^([lmr])([lmr])$")) {
                    char source = s.charAt(0);
                    char target = s.charAt(1);
                    movePiece(source, target);
                } else {
                System.out.println("Ungültige Eingabe! Versuchen Sie es erneut.");
                }
                } catch (Exception e) {
                System.out.println("Versuchen Sie es erneut. Es ist ein Fehler aufgetreten.");
                }
                }
                }

	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}
