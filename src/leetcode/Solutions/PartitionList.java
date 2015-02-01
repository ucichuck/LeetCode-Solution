package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class PartitionList {
	 public ListNode partition(ListNode head, int x) {
	    	ListNode pre1 = new ListNode(-1);
	    	ListNode h1 = pre1;
	    	ListNode pre2 = new ListNode(-1);
	    	ListNode h2 = pre2;
	    	
	    	while(head != null){
	    		if(head.val < x){
	    			pre1.next = head;
	    			pre1 = head;
	    			head = head.next;
	    			pre1.next = null;
	    		}else{
	    			pre2.next = head;
	    			pre2 = head;
	    			head = head.next;
	    			pre2.next = null;
	    		}
	    	}
	    	if(h2.next == null){
	    		return h1.next;
	    	}
	    	pre1.next = h2.next;
	    	return h1.next;
	    }
}
