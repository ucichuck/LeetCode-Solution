package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.Utility.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;

    }
	
	
	public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null){
    		return res;
    	}
    	
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	list.add(root);
    	List<TreeNode> tmpList = new ArrayList<TreeNode>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(root.val);
    	res.add(tmp);
    	int count = 0;
    	while(!list.isEmpty()){
    		TreeNode cur = list.remove(0);
    		if(cur.left != null){
    			tmpList.add(cur.left);
    		}
    		if(cur.right != null){
    			tmpList.add(cur.right);
    		}
    		if(list.isEmpty()){
    			tmp = new ArrayList<Integer>();
    			for(int i=0; i<tmpList.size(); i++){
    				list.add(tmpList.get(i));
    				if(count % 2 ==0){
    					tmp.add(0,tmpList.get(i).val);
    				}else{
    					tmp.add(tmpList.get(i).val);
    				}
    			}
    			if(!tmp.isEmpty()){
    				res.add(tmp);
    			}
    			tmpList = new ArrayList<TreeNode>();
    			count ++;
    		}
    	}
    	return res;
    }
}
