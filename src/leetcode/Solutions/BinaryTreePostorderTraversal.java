package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.Utility.TreeNode;

public class BinaryTreePostorderTraversal {
	 public List<Integer> postorderTraversal(TreeNode root) {
	    	List<Integer> res = new ArrayList<Integer>();
	    	if(root == null){
			return res;
	    	}
	    	
	    	Stack<TreeNode> st = new Stack<TreeNode>();
	    	Stack<TreeNode> st2 = new Stack<TreeNode>();
	    	st.add(root);
	    	while(!st.isEmpty()){
	    		TreeNode cur = st.pop();
	    		st2.push(cur);
	    		if(cur.left != null){
	    			st.add(cur.left);
	    		}
	    		if(cur.right != null){
	    			st.add(cur.right);
	    		}
	    	}
	    	
	    	while(!st2.isEmpty()){
	    		res.add(st2.pop().val);
	    	}
	    	return res;
	    }
}
