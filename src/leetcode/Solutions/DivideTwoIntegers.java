package leetcode.Solutions;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean positive = true;
        long dividendl = dividend;
        long divisorl = divisor;
        if(dividendl<0){
            dividendl = Math.abs(dividendl);
        	positive = !positive;
        }
        if(divisorl <0){
        	divisorl = Math.abs(divisorl);
        	positive = !positive;
        }
        int carry =0;
        while((divisorl<<carry)<=dividendl){
        	carry++;
        	
        }
        carry--;
        int res =0;
        for(int i = carry ; i>=0; i--){
        	if((divisorl<<i)<=dividendl){
        		res += (1 <<i);
        		dividendl -= (divisorl<<i);
        	}
        }

        return positive == true ? res : -(res);
        		
    }
}