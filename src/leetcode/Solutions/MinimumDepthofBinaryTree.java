package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class MinimumDepthofBinaryTree {
	 public int minDepth(TreeNode root) {
	        if(root == null){
	        	return 0;
	        }
	        if(root.left == null){
	        	return minDepth(root.right)+1;
	        }
	        if(root.right == null){
	        	return minDepth(root.left)+1;
	        	
	        }
	        return Math.min(minDepth(root.right), minDepth(root.left))+1;
	    }
}
