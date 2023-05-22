package idh.java;

import java.util.LinkedList;
import java.util.Deque;

public class Disc{
	int name;	 
	int position; 				//bottom - body - head
	
	
	public Disc(int name) {
	this.name = name;			//3 - 2 - 1	
	}


	private int getPosition() {
		return position;
	}

	private void setPosition(int position) {
		this.position = position;
	}

	private int getDiscName() {
		return name;
	}

	public void setDiscName(int name) {
		this.name = name;
	}

//	public void addDisk(String offThisRod, String onThisRod) {
//		this.addDisk(new Disc(position));
//	}
}
