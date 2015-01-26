package leetcode.Solutions;

public class JumpGame {
	public boolean canJump(int[] A) {
        if(A == null || A.length == 0){
        	throw new IllegalArgumentException("wrong input");
        }
        
        int cur = A[0];
        for(int i=1; i< A.length; i++){
        	if(cur == 0){
        		return false;
        	}
        	cur--;
        	cur = Math.max(cur, A[i]);
        }
        return true;
    }
}
