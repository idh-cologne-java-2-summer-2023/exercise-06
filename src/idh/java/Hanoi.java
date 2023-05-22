package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Hanoi {
	Deque<Integer> linkerTurm = new ArrayDeque<>();
	Deque<Integer> mittlererTurm = new ArrayDeque<>();
	Deque<Integer> rechterTurm = new ArrayDeque<>();
	
	public Hanoi() {
		for (int i = 1; i < 10; i++) {
			linkerTurm.add(i);
		}
	}
	
	private void movePiece(char from, char to) {
		int obersteLinks = linkerTurm.peekFirst();							//Ausgangsscheibe
		int obersteMitte;
		int obersteRechts;
		
		 switch (from) {
	        case 'l':
	                switch (to) {
	                    case 'm':
	                    	if (mittlererTurm.isEmpty() || mittlererTurm.peekLast() > obersteLinks) {
	                    		mittlererTurm.addFirst(obersteLinks);
	                    		linkerTurm.remove(obersteLinks);
	                    	}
	                        break;
	                    case 'r':
	                    	if (rechterTurm.isEmpty() || rechterTurm.peekLast() > obersteLinks)
	                    		rechterTurm.addFirst(obersteLinks);
	                    		linkerTurm.remove(obersteLinks);
	                        break; 
	                     }
	         break;
         
        case 'm':
              	if (!mittlererTurm.isEmpty()) {
              		obersteMitte = mittlererTurm.peekFirst();
	        		switch (to) {
		                 case 'l':
		                   	if (linkerTurm.isEmpty() || linkerTurm.peekLast() > obersteMitte){
		                        linkerTurm.addFirst(obersteMitte);
		                  		mittlererTurm.remove(obersteMitte);
				 				}
		                       break;
		                   case 'r':
		                   	if (rechterTurm.isEmpty() || rechterTurm.peekLast() > obersteMitte)
		                       rechterTurm.addFirst(obersteMitte);
		                   		mittlererTurm.remove(obersteMitte);
		                      break;
		              }
	        }
          
            break;
         
        case 'r':
          	if (!rechterTurm.isEmpty()) {
          		obersteRechts = rechterTurm.peekFirst();
        		switch (to) {
	                 case 'l':
	                   	if (linkerTurm.isEmpty() || linkerTurm.peekLast() > obersteRechts){
	                        linkerTurm.addFirst(obersteRechts);
	                  		rechterTurm.remove(obersteRechts);
			 				}
	                       break;
	                   case 'm':
	                   	if (mittlererTurm.isEmpty() || mittlererTurm.peekLast() > obersteRechts) {
	                   		mittlererTurm.addFirst(obersteRechts);
	                   		rechterTurm.remove(obersteRechts);
	                   	}
	                   		break;
	              }
        }
      
        break;
	            
	            
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
		return linkerTurm.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return mittlererTurm.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		return rechterTurm.descendingIterator();
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
