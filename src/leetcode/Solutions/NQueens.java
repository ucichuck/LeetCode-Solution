package leetcode.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	 public List<String[]> solveNQueens(int n) {
	    	List<String[]> arr = new ArrayList<String[]>();
	    	if(n <= 0){
	    		return arr;
	    	}
	    	
	    	int[] board = new int[n];
	    	
	    	cal(board, arr,0,n);
	    	return arr;
	    }
	    
	    private void cal(int[] board, List<String[]> arr, int index, int n){
	    	if(index == n){
	    		String[] tmp = new String[n];
	    		for(int i=0; i<n; i++){
	    			tmp[i] = getString(board[i],n);
	    		}
	    		arr.add(tmp);
	    		return;
	    	}
	    	
	    	for(int i=0; i<n; i++){
	    		board[index] = i;
	    		if(isValid(board,index)){
	    			cal(board,arr,index+1,n);
	    		}
	    		board[index] = 0;
	    	}
	    }
	    
	    private boolean isValid(int[] board, int index){
	    	for(int i=0; i< index; i++){
	    		if(board[i] == board[index] || Math.abs(board[i]-board[index]) == Math.abs(i-index) ){
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    
	    private String getString(int index, int n){
	    	String res = "";
	    	for(int i=0; i<n; i++){
	    		if(i == index){
	    			res+="Q";
	    		}else{
	    			res+=".";
	    		}
	    	}
	    	return res;
	    }
}
