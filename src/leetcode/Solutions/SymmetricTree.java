package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return isSameTree(root.left, root.right);
    }
    private boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null){
            return false;
        }else if(root2 == null){
            return false;
        }else if(root1.val != root2.val){
            return false;
        }
        return isSameTree(root1.left, root2.right) && isSameTree(root1.right, root2.left);
    }
}
