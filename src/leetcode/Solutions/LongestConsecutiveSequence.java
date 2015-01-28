package leetcode.Solutions;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0){
        	return 0;
        }
        
        HashSet<Integer> table = new HashSet<Integer>();
        for(int i : num){
        	table.add(i);
        }
        int max = 0;
        for(int i : num){
        	int left = get(num, table,i, true);
            int right = get(num, table,i, false);
            max = Math.max(max, left+right);
        }
        return max;
        
    }
    private int get(int[] num, HashSet<Integer> table, int key, boolean left){
    	int res = 0;
    	if(left){
    		while(table.contains(key)){
    			table.remove(key);
    			res++;
    			key--;
    		}
    		return res;
    	}else{
    		while(table.contains(key+1)){
    			table.remove(key+1);
    			res++;
    			key++;
    		}
    		return res;
    	}
    }
}
