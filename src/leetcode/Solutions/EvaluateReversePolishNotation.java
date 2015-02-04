package leetcode.Solutions;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
        	return 0;
        }
        
        Stack<Integer> st = new Stack<Integer>();
        for( int i=0; i<tokens.length; i++){
        	if(!isFac(tokens[i])){
        		st.push(Integer.valueOf(tokens[i]));
        	}else{
        		int b = st.pop();
        		int a = st.pop();
        		st.push(cal(a,b,tokens[i]));		
        	}
        }
        return st.pop();
    }
    private boolean isFac(String st){
    	return st.equals("*")||st.equals("/")||st.equals("+")||st.equals("-");
    }
    private int cal(int a, int b, String st){
    	switch(st){
    	case "+": return a+b;
    	case "-": return a-b;
    	case "*" : return a*b;
    	default : return a/b;
    	}
    		
    }
}
