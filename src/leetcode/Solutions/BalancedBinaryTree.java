package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        int res = getDepth(root);
        if(res == -1){
        	return false;
        }else{
        	return true;
        }
    }
    public int getDepth(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	
    	int left = getDepth(root.left);
    	if(left == -1){
    		return -1;
    	}
    	
    	int right = getDepth(root.right);
    	if(right == -1){
    		return -1;
    	}
    	
    	if(Math.abs(left - right) >= 2){
    		return -1;
    	}
    	
    	return Math.max(left, right)+1;
    }
}
