package idh.java;

import java.util.ArrayList;
import java.util.Iterator;

public class IItr implements Iterator<Integer> {
	int i = -1;
	ArrayList<Integer> temp;
	
	public IItr(ArrayList<Integer> temp) {
		this.temp = temp;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return i < temp.size()-1;
	}

	@Override
	public Integer next() {
		i ++;
		return temp.get(i);
	}

}
