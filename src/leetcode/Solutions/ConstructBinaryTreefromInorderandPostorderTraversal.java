package leetcode.Solutions;

import java.util.HashMap;

import leetcode.Utility.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	HashMap<Integer,Integer> table = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      for(int i=0; i<inorder.length; i++){
    	table.put(inorder[i], i);
      }
      return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
  private TreeNode build(int[] postorder, int pl, int pr, int[] inorder, int il, int ir){
	if(pl > pr || il > ir){
		return null;
	}
	
	if(pl == pr || il == ir){
		return new TreeNode(postorder[pr]);
	}
	
	TreeNode cur = new TreeNode(postorder[pr]);
	
	int iin = table.get(postorder[pr]);
	
	TreeNode left = build(postorder, pl, pl+(iin - il-1), inorder, il, iin-1);
	TreeNode right = build(postorder, pl+(iin - il), pr-1, inorder, iin+1, ir);
	
	cur.left = left;
	cur.right = right;
	return cur;
}
}
