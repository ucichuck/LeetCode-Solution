package leetcode.Solutions;

public class PalindromePartitioningII {
	 public int minCut(String s) {
	        if(s == null || s.length() <2){
	        	return 0;
	        }
	        
	        int[] dp = new int[s.length()+1];
	        boolean[][] arr = new boolean[s.length()][s.length()];
	        
	        for(int i= s.length(); i>=0; i--){
	        	dp[i] = s.length() - i;
	        }
	        
	        for(int i=s.length()-1; i>=0; i--){
	        	for(int j = i; j<s.length(); j++){
	        		if(s.charAt(i) == s.charAt(j) &&(j-i < 2 || arr[i+1][j-1])){
	        			arr[i][j] = true;
	        			dp[i] = Math.min(dp[i], dp[j+1]+1);
	        		}
	        	}
	        }
	        return dp[0]-1;
	    }
}
