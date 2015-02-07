package leetcode.Solutions;

public class MajorityElement {
	public int majorityElement(int[] num) {
    	if(num.length == 0){
    		throw new IllegalArgumentException("wrong input");
    	}
    	
    	int cur = 0;
    	int count = 0;
    	for(int a : num){
    		if(count == 0){
    			cur = a;
    			count++;
    			continue;
    		}
    		if(cur == a){
    			count++;
    		}else{
    			count--;
    		}
    	}
    	if(count < 1){
    		throw new IllegalArgumentException("wrong input");
    	}
    	return cur;
    }
}
