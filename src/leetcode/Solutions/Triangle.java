package leetcode.Solutions;

import java.util.List;

public class Triangle {
	 public int minimumTotal(List<List<Integer>> triangle) {
	        if(triangle == null || triangle.size() == 0){
	        	return 0;
	        }
	        int len = triangle.size();
	        
	        int[] arr = new int[len];
	        
	        for(int i= len-1; i>=0; i--){
	        	if(i==len-1){
	        		for(int j=0; j<triangle.get(i).size(); j++){
	        			arr[j] = triangle.get(i).get(j);
	        		}
	        	}else{
	        		for(int j=0; j<triangle.get(i).size(); j++){
	        			arr[j] = Math.min(arr[j], arr[j+1])+triangle.get(i).get(j);
	        		}
	        	}
	        }
	        return arr[0];
	    }
}
