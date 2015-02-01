package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST1(TreeNode root) {
        return inorderTraverse(root);
    }
    
    TreeNode prev = null;
    public boolean inorderTraverse(TreeNode root) {
        if (root == null)
            return true;
        if (!inorderTraverse(root.left))
            return false;
        if (prev != null) {
            if (root.val <= prev.val)
                return false;
        }
        prev = root;
        if (!inorderTraverse(root.right))
            return false;
        return true;
    }
    
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
        	return true;
        }
        Long min = (long)Integer.MIN_VALUE - 1;
        Long max = (long)Integer.MAX_VALUE + 1;
        return isValid(root, min, max);
    }
    private boolean isValid(TreeNode root, long min, long max){
    	if(root.val >=max || root.val <=min){
    		return false;
    	}
    	boolean res = true;
    	if(root.left != null){
    		res = isValid(root.left, min, root.val);
    		if(!res){
    			return res;
    		}
    	}
    	
    	if(root.right != null){
    		res = isValid(root.right, root.val, max);
    		if(!res){
    			return res;
    		}
    	}
    	
    	return res;
    }
}
