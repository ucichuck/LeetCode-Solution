package leetcode.Solutions;

public class UniqueBinarySearchTrees {
	 public int numTrees(int n) {
	    	if(n <= 1){
	    		return n;
	    	}
	        int[] table = new int[n+1];
	        table[0] = 1;
	        table[1] = 1;
	        for(int i=2; i<=n; i++){
	        	int sum = 0;
	        	for(int j=0; j<i; j++){
	        		sum += table[i-j-1]*table[j];
	        	}
	        	table[i] = sum;
	        }
	        
	        return table[n];
	    }
}
