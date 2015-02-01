package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.Utility.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
        if(root == null){
        	return res;
        }
        Stack<TreeNode> table = new Stack<TreeNode>();
        
        while(root != null){
        	table.push(root);
        	root = root.left;
        }
        
        while(!table.isEmpty()){
        	TreeNode cur = table.pop();
        	res.add(cur.val);
        	cur = cur.right;
        	while(cur != null){
        		table.push(cur);
        		cur = cur.left;
        	}
        }
        return res;
    }
}
