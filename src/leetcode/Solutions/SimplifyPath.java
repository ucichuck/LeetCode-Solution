package leetcode.Solutions;

import java.util.Stack;

public class SimplifyPath {
	 public String simplifyPath(String path) {
	        if(path == null || path.isEmpty()){
	        	return "";
	        }
	        if(path.charAt(0) != '/'){
	        	return "";
	        }
	        
	        Stack<String> st = new Stack<String>();
	        int index = 0;
	        while(index < path.length()){
	        	while(index < path.length() && path.charAt(index) == '/' ){
	        		index++;
	        	}
	        	if(index == path.length()){
	        		break;
	        	}
	        	
	        	int start = index;
	        	int end = index +1;
	        	while(end < path.length() && path.charAt(end) != '/'){
	        		end++;
	        	}
	        	String cur = path.substring(start,end);
	        	index = end;
	        	
	        	if(cur.equals("..")){
	        		if(!st.isEmpty()){
	        			st.pop();
	        		}
	        	}else if(cur.equals(".")){
	        		continue;
	        	}else{
	        		st.push(cur);
	        	}
	        }
	        
	        String res = "";
	        if(!st.isEmpty()){
	        	while(!st.isEmpty()){
	            	res = "/"+st.pop() + res;
	            }
	        }else{
	        	return "/";
	        }
	        return res;
	    }
}
