package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

import leetcode.Utility.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	List<TreeNode> level = new ArrayList<TreeNode>();
    	if(root == null){
    		res.add(tmp);
    		return res;
    	}
    	level.add(root);
    	List<TreeNode> level2 = new ArrayList<TreeNode>();
    	while(!level.isEmpty()){
    		TreeNode cur = level.remove(0);
    		tmp.add(cur.val);
    		if(cur.left != null){
    			level2.add(cur.left);
    		}
    		if(cur.right != null){
    			level2.add(cur.right);
    		}
    		if(level.isEmpty()){
    			res.add(tmp);
    			tmp = new ArrayList<Integer>();
    			level = level2;
    			level2 = new ArrayList<TreeNode>();
    		}
    	}
    	return res;
    }
}
