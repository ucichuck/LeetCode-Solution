package leetcode.Utility;

import java.util.Iterator;

public class MyIterable implements Iterable<Integer>{
	Iterator[] iters;
	public MyIterable(Iterator[] iters){
		this.iters = iters;
	}
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			private int[] numbers = new int[iters.length];
			private boolean[] valids= new boolean[iters.length];
			
			 
			public void remove() {
				throw new UnsupportedOperationException();
			    }
			
			public boolean hasNext(){
				for(boolean tmp : valids){
					if(tmp){
						return true;
					}
				}
				
				for(Iterator tmp : iters){
					if(tmp.hasNext()){
						return true;
					}
				}
				return false;
			}
			
			public Integer next(){
				if(!hasNext()){
					throw new IllegalArgumentException();
				}
				int val = Integer.MAX_VALUE;
				int index = -1;
				for(int i=0;i <iters.length; i++){
					if(valids[i] && numbers[i] < val ){
						val = numbers[i];
						index = i;
					}
				}
				
				if(iters[index].hasNext()){
					numbers[index] = (int)iters[index].next();
				}else{
					valids[index] = false;
				}
				
				return val;
			}
		};
	}
}
