package leetcode.Solutions;

public class CompareVersionNumbers {
	 public int compareVersion(String version1, String version2) {
	        if(version1.isEmpty() && version2.isEmpty())return 0;
	        
	        int left = 0;
	        int right = 0;
	        
	        while(left < version1.length() && version1.charAt(left)!='.'){
	        	left++;
	        }
	        while(right < version2.length() && version2.charAt(right)!='.'){
	        	right++;
	        }
	        
	        int a = version1.isEmpty() ? 0 :Integer.valueOf(version1.substring(0,left));
	        int b = version2.isEmpty() ? 0 :Integer.valueOf(version2.substring(0,right));
	        if(a < b){
	        	return -1;
	        }else if(a > b){
	        	return 1;
	        }else{
	        	return compareVersion(left == version1.length()? "" : version1.substring(left+1),
	        			right == version2.length()? "" : version2.substring(right+1));
	        }
	        
	    }
}
