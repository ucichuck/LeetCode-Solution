package leetcode.Solutions;

public class POWxn {
	public class Solution {
	    public double pow(double x, int n) {
	        if(n == 0){
	        	return 1;
	        }
	        if(n == 1){
	            return x;
	        }
	        
	        if(n < 0){
	        	x = 1/x;
	        	n = -n;
	        }
	        
	        double m = x;
	        
	        	m = pow(x*x, n/2);
	        	if(n%2 != 0){
	        		m = m*x;
	        	}
	        return m;	
	    }
	}
}
