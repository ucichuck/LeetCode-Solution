package leetcode.Solutions;

public class Numberof1Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
    	for( int i=1; i<=32; i++){
        	if(cal(n,i)){
        		count++;
        	}
        }
    	return count;
    }
    private boolean cal(int n, int i){
    	return (n & (1 << i)) != 0;
    }
}
