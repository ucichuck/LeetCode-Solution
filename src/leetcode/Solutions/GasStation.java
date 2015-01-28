package leetcode.Solutions;

public class GasStation {
	 public int canCompleteCircuit(int[] gas, int[] cost) {
	        if(gas.length == 0 || cost.length == 0){
	        	return 0;
	        }
	        if(gas.length == 1){
	        	return (gas[0]-cost[0]) < 0 ? -1 : 0;
	        }
	    	int start = 0;
	    	int end = 1;
	    	int left = gas[0]-cost[0];
	    	while(start != end){
	    		if(left < 0){
	    			start --;
	    			if(start == -1){
	    				start = gas.length-1;
	    			}
	    			left = left + gas[start] - cost[start];
	    		}else{
	    			left = left + gas[end] - cost[end];
	    			end ++;
	    			if(end == gas.length){
	    				end = 0;
	    			}
	    			
	    		}
	    	}
	    	if(left < 0){
	    		return -1;
	    	}
	    	return start;
	        
	    }
}
