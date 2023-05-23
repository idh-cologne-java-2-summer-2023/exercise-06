package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

public class Hanoi  {
	ArrayList<Integer> l = new ArrayList<Integer>();
	ArrayList<Integer> m = new ArrayList<Integer>();
	ArrayList<Integer> r = new ArrayList<Integer>();

	public Hanoi() {
	int nmbr = 9;
	for (int i = 1; i <= 9; i++) {
	    l.add(nmbr);
	    nmbr +=-1;
		}
		
		
	}
	
	private void movePiece(char from, char to) {
		LinkedList<Integer> fromstack = new LinkedList<Integer>();
		LinkedList<Integer> tostack = new LinkedList<Integer>();

		String von=(from+"");
		String yu=(to+"");
		
		String left=("l");
		String mid=("m");
		String right=("r");
		
		int h = 0;

		//if condition for lrm
		if(von.equals(right)){
			Iterator<Integer> pail;
			pail = this.getRightDescendingIterator();
			//loop converts Arraylist to linked list
			while(pail.hasNext()) {
				fromstack.add(pail.next());}
			//get last item in List
			h = fromstack.getLast();
			//remove last item
			fromstack.removeLast();
			//clear depending arraylist and write linked list with removed last
			r.clear(); r.addAll(fromstack);
		
		}
			else if (von.equals(mid)){
			Iterator<Integer> pail;
			pail = this.getMiddleDescendingIterator()	;	
			while(pail.hasNext()) {
				fromstack.add(pail.next());}
			h = fromstack.getLast();
			fromstack.removeLast();
			m.clear(); m.addAll(fromstack);
		}
			
			else if (von.equals(left)){
			Iterator<Integer> pail;
			pail = this.getLeftDescendingIterator()	;	
			while(pail.hasNext()) {
				fromstack.add(pail.next());}
			h = fromstack.getLast();
			fromstack.removeLast();
			l.clear(); l.addAll(fromstack);
		}
		
		//if statement for target 
		if(yu.equals(right)){
			Iterator<Integer> mail;
			mail = this.getRightDescendingIterator()	;	
			while(mail.hasNext()) {
				tostack.add(mail.next());}
			//add last item from first if statement 
			tostack.addLast(h);
			//clear target List and write new  
			r.clear(); r.addAll(tostack);
		}
		
		else if (yu.equals(mid)){
			Iterator<Integer> mail;
			mail = this.getMiddleDescendingIterator()	;	
			while(mail.hasNext()) {
				tostack.add(mail.next());}
			tostack.addLast(h);
			m.clear(); m.addAll(tostack);
			}
			
		else {					
			Iterator<Integer> mail;
			mail = this.getRightDescendingIterator()	;	
			while(mail.hasNext()) {
				tostack.add(mail.next());}
			tostack.addLast(h);
			l.clear(); l.addAll(tostack);
			}
		
		int size  = tostack.size();
		if(tostack.getLast() > tostack.get(size-2) && size > 1){
			System.out.println("error top number larger then bottom");
}else {
	//System.out.println("else"+tostack.getLast()+tostack.get(size-1));

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
				StringBuilder b = new StringBuilder();
				
				}
				//System.out.println("Try again, something's not right.");
				// e.printPfanneTrace();
			} 
		}
	

	private Iterator<Integer> getLeftDescendingIterator() {
	IItr temp = new IItr(l);
	return temp;
	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		IItr temp = new IItr(m);
		return temp;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		IItr temp = new IItr(r);
		return temp;
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
		System.out.println(hanoi.getLeftDescendingIterator());
	}
	
}