package leetcode.Solutions;

public class ReverseWordsinaString {
	 public String reverseWords(String s) {
	    	StringBuilder st = new StringBuilder();
	    	int j = s.length();
	    	for(int i = s.length()-1; i>=0; i--){
	    		if(s.charAt(i) == ' '){
	    			j = i;
	    		} else if( i == 0 || s.charAt(i-1) == ' ') {
	    			if(st.length() != 0){
	    				st.append(" ");
	    			}
	    			st.append(s.substring(i,j));
	    		}
	    	}
	    	return st.toString();
	    }
}
