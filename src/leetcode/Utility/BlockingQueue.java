package leetcode.Utility;

import java.util.ArrayList;

public class BlockingQueue {
	private ArrayList<Integer> arr;
	private int capacity;
	
	public BlockingQueue(int capacity){
		arr = new ArrayList<Integer>();
		this.capacity = capacity;
	}
	
	public synchronized void enqueue(int input) throws InterruptedException {
		while(capacity == arr.size()){
			wait();
		}
		
		if(arr.size() == 0){
			notifyAll();
		}
		
		arr.add(input);
	}
	
	public synchronized int dequeue() throws InterruptedException{
		while(arr.size() == 0){
			wait();
		}
		if(arr.size() == capacity){
			notifyAll();
		}
		
		return arr.remove(arr.size()-1);
	}
	
	
}
