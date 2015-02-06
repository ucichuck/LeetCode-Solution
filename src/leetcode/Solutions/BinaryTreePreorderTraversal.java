package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.Utility.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null){
    		return res;
    	}
    	
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	st.add(root);
    	while(!st.isEmpty()){
    		TreeNode cur = st.pop();
    		res.add(cur.val);
    		if(cur.right != null){
    			st.add(cur.right);
    		}
    		if(cur.left != null){
    			st.add(cur.left);
    		}
    	}
    	return res;
    }
}
