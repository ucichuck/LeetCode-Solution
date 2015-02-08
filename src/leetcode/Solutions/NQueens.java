package leetcode.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
    	List<String[]> res = new ArrayList<String[]>();
        if(n <= 0){
        	return res;
        }
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
        	arr[i] = -1;
        }
        
        List<int[]> boards = new ArrayList<int[]>();
        
        cal(0, n ,arr,boards);
        
        for(int[] a : boards){
        	String[] sss = new String[n];
        	for(int j=0; j<a.length; j++){
        		String tmp = "";
        		for(int i=0; i<n; i++){
            		if(i == a[j]){
            			tmp+="Q";
            		}else{
            			tmp+=".";
            		}
            	}
        		sss[j] = tmp;
        	}
        	res.add(sss);
        }
        return res;
    }
    private void cal(int index, int n, int[] arr , List<int[]> boards){
    	if(n == index){
    		int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
    		boards.add(arr2);
    		return; // bug: remember to Write return, otherwise use if else!!!!!
    	}
    	
    	for(int i=0; i<n; i++){
    		arr[index] = i;
    		if(isValid(arr, index)){
    			cal(index+1, n, arr, boards);
    		}
    		arr[index] = -1;
    	}
    }
    
    private boolean isValid(int[] arr, int index){
    	if(index == 0){
    		return true;
    	}
    	
    	for(int i=0; i<index; i++){
    		if(arr[i] == arr[index]){
    			return false;
    		}
    		
    		if(Math.abs(i-index) == Math.abs(arr[i] - arr[index])){
    			return false;
    		}
    	}
    	return true;
    }
}
