package leetcode.Solutions;

import java.util.Stack;

public class LongestValidParentheses {
	 public int longestValidParentheses(String s) {
	        if(s == null || s.length() <= 1){
	        	return 0;
	        }
	        
	        Stack<Integer> lefts = new Stack<Integer>();
	        int start = -1;
	        int max = 0;
	        for(int i=0; i<s.length(); i++){
	        	if(s.charAt(i) == '('){
	        		lefts.add(i);
	        	}else{
	        		
	        		if(lefts.isEmpty()){
	        			start = i;
	        		}else{
	        			lefts.pop();
	        			if(lefts.isEmpty()){
	        				max = Math.max(max, i-start);
	        			}else{
	        				max = Math.max(max, i-lefts.peek());
	        			}
	        		}
	        	}
	        }
	        return max;
	    }
}
