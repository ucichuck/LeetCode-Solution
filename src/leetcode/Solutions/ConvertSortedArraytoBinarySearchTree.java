package leetcode.Solutions;

import leetcode.Utility.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0){
        	return null;
        }
        
        return build(num, 0, num.length-1);
    }
    private TreeNode build(int[] num, int left, int right){
    	if(left > right){
    		return null;
    	}
    	
    	int mid = (left+right)/2;
    	TreeNode cur = new TreeNode(num[mid]);
    	TreeNode leftN = build(num, left, mid-1);
    	TreeNode rightN = build(num, mid+1, right);
    	cur.left = leftN;
    	cur.right = rightN;
    	return cur;
    }
}
