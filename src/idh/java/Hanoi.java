package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Hanoi {
	Queue<Integer> zahlenStart;
	Queue<Integer> mitte;
	Queue<Integer> rechts;
	int[] z = {9,8,7,6,5,4,3};
	int[] m = new int[z.length];
	int[] r = new int[z.length];
	
	
	
	public Hanoi() {
		this.zahlenStart = new LinkedList<Integer>();
		this.mitte = new LinkedList<Integer>();
		this.rechts = new LinkedList<Integer>();
		
		zahlenStart.add(z[0]);
		zahlenStart.add(z[1]);
		zahlenStart.add(z[2]);
		zahlenStart.add(z[3]);
		zahlenStart.add(z[4]);
		zahlenStart.add(z[5]);
		zahlenStart.add(z[6]);

		this.toString();
	}
	
	private void movePiece(char from, char to) {
		String s = new StringBuilder().append(from).append(to).toString();
		switch(s) {
			case "lm":
				mitte.add(zahlenStart.remove());
				break;
			case "lr":
				rechts.add(zahlenStart.remove());
				break;
			case "ml":
				zahlenStart.add(mitte.remove());
				break;
			case "mr":
				rechts.add(mitte.remove());
				break;
			case "rl":
				zahlenStart.add(rechts.remove());
				break;
			case "rm":
				mitte.add(rechts.remove());
				break;	
			default:
				System.out.println("Something must went wrong here");
				
		}
		
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
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return new Iterator<Integer>() {
		public boolean hasNext() {
			return zahlenStart.peek() != null;
		}

		public Integer next() {
			StringBuilder t = new StringBuilder();
			for (int i : z)
		    {
		         t.append(i);
		    }
			return Integer.parseInt(t.toString());
			
			
		}
		};

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return mitte.peek() != null;
			}

			public Integer next() {
				StringBuilder t = new StringBuilder();
				for (int i : m)
			    {
			         t.append(i);
			    }
				return Integer.parseInt(t.toString());
			}
			};

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return rechts.peek() != null;
			}

			public Integer next() {
				StringBuilder t = new StringBuilder();
				for (int i : r)
			    {
			         t.append(i);
			    }
				return Integer.parseInt(t.toString());
			}
			};
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
