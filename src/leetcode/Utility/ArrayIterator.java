package leetcode.Utility;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {
	int[] array;
	int index;
	
	public ArrayIterator(int[] arr){
		this.array = arr;
		this.index = 0;
		while(index < this.array.length && this.array[index] <= 0){
			index++;
		}
	}
	
	public boolean hasNext(){
		return index < this.array.length;
	}
	
	public Integer next(){
		if(index >= this.array.length){
			throw new IllegalArgumentException("out of index");
		}
		
		int val = this.array[index];
		index++;
		while(index < this.array.length && this.array[index] <= 0){
			index++;
		}
		return val;
	}

	@Override
	public void remove() {
		this.array[index-1] = Integer.MIN_VALUE;
		
	}
}
