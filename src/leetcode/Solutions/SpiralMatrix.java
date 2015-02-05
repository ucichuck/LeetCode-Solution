package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	 public List<Integer> spiralOrder(int[][] matrix) {
	    	List<Integer> res = new ArrayList<Integer>();
	        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
	        	return res;
	        }
	        
	        int k = matrix.length;
	        int l = matrix[0].length;
	        int x = 0;
	        int y = 0;
	      while(k >0 && l > 0){
	    	if(k == 1){
	    		for(int i=0; i<l; i++){
	    			res.add(matrix[x][y++]);
	    		}
	    		break;
	    	}else if(l == 1){
	    		for(int i =0; i<k; i++){
	    			res.add(matrix[x++][y]);
	    		}
	    		break;
	    	}
	    	
	    	for(int i=0; i<l-1; i++){
	    		res.add(matrix[x][y++]);
	    	}
	    	
	    	for(int i=0; i<k-1; i++){
	    		res.add(matrix[x++][y]);
	    	}
	    	
	    	for(int i=0; i<l-1; i++){
	    		res.add(matrix[x][y--]);
	    	}
	    	
	    	for(int i=0; i<k-1; i++){
	    		res.add(matrix[x--][y]);    	}
	    	
	    	x++;
	    	y++;
	    	k = k-2;
	    	l = l-2;
	    }
	    return res;
	    }
}
