package leetcode.Solutions;

import java.util.ArrayList;

import leetcode.Utility.TreeNode;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1, n);
    }
 
    private ArrayList<TreeNode> generateTrees(int begin, int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(begin > end) result.add(null);
        else{
            for(int i = begin; i <= end; i++){
                ArrayList<TreeNode> left = generateTrees(begin, i - 1);
                ArrayList<TreeNode> right = generateTrees(i + 1, end);
                for(int j = 0; j < left.size(); j++){
                    for(int k = 0; k < right.size(); k++){
                        TreeNode node = new TreeNode(i);
                        node.left = left.get(j);
                        node.right = right.get(k);
                        result.add(node);
                    }
                }
            }
        }
        return result;
    }
}
