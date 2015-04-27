package leetcode.Solutions;

public class Numberof1Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
    	for( int i=0; i<32; i++){
        	if(cal(n,i)){
        		count++;
        	}
        }
    	return count;
    }
    private boolean cal(int n, int i){
    	return (n & (1 << i)) != 0;
    }
    
    
    public int hammingWeight2(int n) {
        
        int count = 0;
        while(n != 0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}
