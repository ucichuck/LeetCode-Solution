package leetcode.Solutions;

import java.util.Stack;

import leetcode.Utility.TreeNode;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if(root == null){
        	return;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode pre = new TreeNode(-1);
        while(!st.isEmpty()){
        	TreeNode cur = st.pop();
        	pre.right = cur;
        	pre.left = null;
        	pre = cur;
        	if(cur.right != null){
        		st.add(cur.right);
        	}
        	if(cur.left != null){
        		st.add(cur.left);
        	}
        }
        
    }
}
