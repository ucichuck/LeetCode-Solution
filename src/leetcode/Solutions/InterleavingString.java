package leetcode.Solutions;

public class InterleavingString {
	 public boolean isInterleave(String s1, String s2, String s3) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if (s1 == null || s2 == null || s3 == null) return false;
	        if (s1.length() + s2.length() != s3.length()) return false;
	        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
	        dp[0][0] = true;
	        for(int i = 0; i < s1.length() + 1; i++) {
	            for(int j = 0; j < s2.length() + 1; j++) {
	            	if(i == 0 && j == 0){
	            		dp[i][j] = true;
	            	}else if(i == 0){
	            		if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
	                        dp[0][j] = true;
	                    }
	            	}else if(j == 0){
	            		if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
	                        dp[i][0] = true;
	                    }
	            	}else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
	                    dp[i][j] = true;
	                }else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
	                    dp[i][j] = true;
	                }
	            }
	        }
	        return dp[s1.length()][s2.length()];
	    }
}
