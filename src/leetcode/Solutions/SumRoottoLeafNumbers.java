package leetcode.Solutions;

import java.util.ArrayList;

import leetcode.Utility.TreeNode;

public class SumRoottoLeafNumbers {
	 public int sumNumbers(TreeNode root) {
	        if(root == null){
	        	return 0;
	        }
	        
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        cal(root, 0, res);
	        int sum = 0;
	        for(Integer tmp : res){
	        	sum += tmp;
	        }
	        return sum;
	    }
	    
	    private void cal(TreeNode root, int sum, ArrayList<Integer> res){
	    	if(root.left == null && root.right == null){
	    		res.add(sum*10+root.val);
	    	}
	    	
	    	if(root.left != null){
	    		cal(root.left,sum*10+root.val, res);
	    	}
	    	
	    	if(root.right != null){
	    		cal(root.right,sum*10+root.val, res);
	    	}
	    }
}
