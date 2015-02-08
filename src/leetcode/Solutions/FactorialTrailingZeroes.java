package leetcode.Solutions;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        if(n< 4){
        	return 0;
        }
        
        int ret = 0;
        while(n>0)
        {
            ret += n/5;
            n /= 5;
        }
        return ret;
    }
}
