package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	public Stack<Integer> stL = new Stack<Integer>();
	public Stack<Integer> stM = new Stack<Integer>();
	public Stack<Integer> stR = new Stack<Integer>();

	public Hanoi() {
		
		for (int i = 9; i > 0; i--) {
			stL.push(i);
		}
	}
	
	private void movePiece(char from, char to) {
		
		switch (from) {
			case 'l': {
				
				switch (to) {
				
					case 'l': {
						
						stL.push(stL.pop());
						
						break;}
					
					case 'm': {
						
						if(stL.peek() > stM.peek() ) {
							
							System.out.println("You cant move this way");
							
							break;}
						
							stM.push(stL.pop());
								
						break;}
				
					case 'r': {
						
						if(stL.peek() > stR.peek() ) {
							
							System.out.println("You cant move this way");
							
							break;}
						
						stR.push(stL.pop());
						
						break;}
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + to);
				}
				
				break;
			}
			
			case 'm': {
				
				switch (to) {
				
				case 'l': {
					
					if(stM.peek() > stL.peek() ) {
						
						System.out.println("You cant move this way");
						
						break;}
					
					stL.push(stM.pop());
					
					break;}
				
				case 'm': {
					
					stM.push(stM.pop());
							
					break;}
			
				case 'r': {
					
					if(stM.peek() > stR.peek() ) {
						
						System.out.println("You cant move this way");
						
						break;}
					
					stR.push(stM.pop());
					
					break;}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + to);
			}
						
				break;
					}
			
			case 'r': {
				
				switch (to) {
				
				case 'l': {
					
					if(stR.peek() > stL.peek() ) {
						
						System.out.println("You cant move this way");
						
						break;}
					
					stL.push(stR.pop());
					
					break;}
				
				case 'm': {
					
					if(stR.peek() > stM.peek() ) {
						
						System.out.println("You cant move this way");
						
						break;}
					
					stM.push(stR.pop());
							
					break;}
			
				case 'r': {
					
					stR.push(stR.pop());
					
					break;}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + to);
			}
				
				break;
			}
			
		
			default:
				throw new IllegalArgumentException("Unexpected value: " + from);
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
		
		return stL.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		
		return stM.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		
		return stR.iterator();
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
