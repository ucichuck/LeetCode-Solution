package leetcode.Solutions;

public class ClimbingStairs {
	public int climbStairs(int n) {
        if(n <=2){
        	return n;
        }
    	int a = 1;
    	int b = 2;
    	while( n > 2){
    		int c = a+b;
    		a = b;
    		b = c;
    		n--;
    	}
    	return b;
    }
}
