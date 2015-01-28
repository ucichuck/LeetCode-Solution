package leetcode.Solutions;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int[] res = maxPathSums(root);
        return res[1];
    }
    
    public int[] maxPathSums(TreeNode root){
        int[] res = new int[2];
        if(root==null){
            res[0]=Integer.MIN_VALUE; // Must be min value since it will add root.val;
            res[1]=Integer.MIN_VALUE;
            return res;
        }
        int[] fromLeft = maxPathSums(root.left),
              fromRight = maxPathSums(root.right);
        
        int temp1 = fromLeft[0]>0?(fromLeft[0]+root.val):root.val;
        int temp2 = fromRight[0]>0?(fromRight[0]+root.val):root.val;
        
        res[0]=Math.max(temp1,temp2);
        res[1]=Math.max(fromLeft[1],Math.max(fromRight[1], Math.max(temp1+temp2-root.val,res[0]))); //double root.val and if fromLeft or fromRightis negative will not be added.
        
        return res;
    }
}
