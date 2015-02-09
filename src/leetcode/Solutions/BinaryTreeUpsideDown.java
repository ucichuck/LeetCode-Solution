package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class BinaryTreeUpsideDown {
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root == null){
        	return root;
        }
        
        TreeNode parent = null, parentRight = null;
        while(root != null){
        	TreeNode left = root.left;
        	TreeNode right = root.right;
        	root.left = parentRight;
        	root.right = parent;
        	parent = root;
        	parentRight = right;
        	root = left;
        }
        return parent;
    }
}
