package leetcode.Solutions;

import java.util.Stack;

import leetcode.Utility.TreeNode;

public class BSTIterator {
	private Stack<TreeNode> stc;
    public BSTIterator(TreeNode root) {
        stc = new Stack<TreeNode>();
       
        while(root != null){
        	 stc.add(root);
        	 root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stc.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode cur = stc.pop();
    	int res = cur.val;
    	cur = cur.right;
    	while(cur!= null){
    		stc.push(cur);
    		cur = cur.left;
    	}
    	return res;
    }
}