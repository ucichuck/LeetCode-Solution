package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        if(root.left == null){
        	return maxDepth(root.right) + 1;
        }else if(root.right == null){
        	return maxDepth(root.left)+1;
        }else{
        	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
