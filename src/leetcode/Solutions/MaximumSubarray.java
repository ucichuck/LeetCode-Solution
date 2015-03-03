package leetcode.Solutions;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
	       if(A.length == 0){
	           return 0;
	       } 
	       
	       int max = Integer.MIN_VALUE;
	       int last = 0;
	       for(int i=0; i<A.length; i++){
	           last = Math.max(A[i],A[i]+last);
	           if(last > max){
	               max = last;
	           }
	       }
	       return max;
	    }
}
