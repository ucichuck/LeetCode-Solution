package leetcode.Solutions;

import leetcode.Utility.ListNode;
import leetcode.Utility.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	ListNode head = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
        	return null;
        }
        
        ListNode cur = head;
        int count = 0;
        while(cur != null){
        	count++;
        	cur = cur.next;
        }
        
        this.head = head;
        return get(0, count-1);
    }
    private TreeNode get(int left, int right){
    	if(left > right){
    		return null;
    	}
    	int mid = (left+right)/2;
    	TreeNode leftNode = get(left,mid - 1);
    	TreeNode cur = new TreeNode(head.val);
    	head = head.next;
    	cur.left = leftNode;
    	TreeNode rightNode = get(mid+1, right);
    	cur.right = rightNode;
    	return cur;
    }
}
