package leetcode.Solutions;

import java.util.HashMap;

import leetcode.Utility.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	HashMap<Integer,Integer> table = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++){
        	table.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
    	if(pl > pr || il > ir){
    		return null;
    	}
    	
    	if(pl == pr || il == ir){
    		return new TreeNode(preorder[pl]);
    	}
    	
    	TreeNode cur = new TreeNode(preorder[pl]);
    	
    	int iin = table.get(preorder[pl]);
    	
    	TreeNode left = build(preorder, pl+1, pl+(iin - il), inorder, il, iin-1);
    	TreeNode right = build(preorder, pl+(iin - il)+1, pr, inorder, iin+1, ir);
    	
    	cur.left = left;
    	cur.right = right;
    	return cur;
    }
}
