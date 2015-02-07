package leetcode.Solutions;

import java.util.Stack;

public class MinStack {
	Stack<Integer> st1 = new Stack<Integer>();
	Stack<Integer> st2 = new Stack<Integer>();
	
    public void push(int x) {
        st1.push(x);
        if(st2.isEmpty()){
        	st2.push(x);
        }else{
        	if(x <= getMin()){
        		st2.push(x);
        	}
        }
    }

    public void pop() {
    	if(st1.isEmpty()){
        	throw new IllegalArgumentException("no min");
        }else{
        	int res = st1.pop();
        	if(res == getMin()){
        		st2.pop();
        	}
        }
    }

    public int top() {
        if(st1.isEmpty()){
        	throw new IllegalArgumentException("no min");
        }else{
        	return st1.peek();
        }
    }

    public int getMin() {
        if(st2.isEmpty()){
        	throw new IllegalArgumentException("no min");
        }else{
        	return st2.peek();
        }
    }
}
