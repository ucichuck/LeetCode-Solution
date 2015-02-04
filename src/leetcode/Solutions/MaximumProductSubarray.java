package leetcode.Solutions;

public class MaximumProductSubarray {
	 public int maxProduct(int[] A) {
	        if(A == null || A.length <= 0){
	        	return 0;
	        }
	        int max = A[0];
	        int maxcon = A[0];
	        int mincon = A[0];
	        for(int i=1; i<A.length; i++){
	        	int tmp1  = Math.max(A[i], Math.max(A[i]*maxcon, A[i]*mincon));
	        	int tmp2 = Math.min(A[i], Math.min(A[i]*maxcon, A[i]*mincon));
	        	maxcon = tmp1;
	        	mincon = tmp2;
	        	if(maxcon > max){
	        		max = maxcon;
	        	}
	        }
	        return max;
	    }
}
