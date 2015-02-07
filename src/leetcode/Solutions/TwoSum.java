package leetcode.Solutions;

import java.util.HashMap;

public class TwoSum {
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	public void add(int number) {
	    int count = map.get(number) == null ? 0 : map.get(number);
	    map.put(number, count+1);
	}

	public boolean find(int value) {
	    for(int num : map.keySet()){
	    	int another = value - num;
	    	if(!map.containsKey(another)){
	    		continue;
	    	}else{
	    		if(another == num){
	    			return map.get(another) >= 2;
		    	}else{
		    		return true;
		    	}
	    	}
	    }
	    return false;
	}
}