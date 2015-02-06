package leetcode.Solutions;

public class DivideTwoIntegers {
	 public int divide(int dividend, int divisor) {
	        if(dividend == Integer.MIN_VALUE && divisor == -1){
	            return Integer.MAX_VALUE;
	        }
	        boolean negative = (dividend > 0 && divisor < 0) ||
	            (dividend < 0 && divisor > 0);

	        long a = Math.abs((long)dividend);
	        long b = Math.abs((long)divisor);
	        int ans = 0;

	        while (a >= b) {
	            int shift = 0;
	            while ((b << shift) <= a) {
	                shift++;
	            }
	            ans += 1 << (shift-1);
	            a = a - (b << (shift-1));
	        }

	        return negative ? -ans : ans;
	    }
}
