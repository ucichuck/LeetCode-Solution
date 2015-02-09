package leetcode.Solutions;

import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < n; i++){
            if(stack.empty() || height[stack.peek()] <= height[i]){
                left[i] = i;
                stack.push(i);
            }else{
                while(!stack.empty() && height[stack.peek()] > height[i]){
                    int idx = stack.pop();
                    left[i] = left[idx];
                    max = Math.max(max, height[idx] * (i - left[idx]));
                }
                stack.push(i);
            }
        }
        while(!stack.empty()){
            int idx = stack.pop();
            max = Math.max(max, height[idx] * (n - left[idx]));
        }
        return max;
    }
}
