package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

import leetcode.Utility.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	if(root == null){
    		return res;
    	}
    	tmp.add(root.val);
    	build(root, sum, tmp, res);
    	return res;
    }
    private void build(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res){
    	if(root.left == null && root.right == null){
    		if(sum == root.val){
    			List<Integer> tmp2 = new ArrayList<Integer>();
    			tmp2.addAll(tmp);
    			res.add(tmp);	
    		}
    		return;
    	}
    	
    	if(root.left != null){
    		tmp.add(root.left.val);
    		build(root.left,sum-root.val,tmp,res);
    		tmp.remove(tmp.size()-1);
    	}
    	
    	if(root.right != null){
    		tmp.add(root.right.val);
    		build(root.right,sum-root.val,tmp,res);
    		tmp.remove(tmp.size()-1);
    	}
    }
}
