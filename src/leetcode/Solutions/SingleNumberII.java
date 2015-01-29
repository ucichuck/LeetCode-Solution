package leetcode.Solutions;

public class SingleNumberII {
	public int singleNumber(int[] A) {
	      if(A == null || A.length == 0){
	    	return 0;
	    }
	      int one = 0, two = 0, three = 0;
	      for(int i=0; i<A.length; i++){
	    	  two |= one & A[i];
	    	  one ^= A[i];
	    	  three = two & one;
	    	  
	    	  one &= ~three;
	    	  two &= ~three;
	      }
	      return one;
	    }
}
