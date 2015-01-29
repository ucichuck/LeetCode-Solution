package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class LinkedListCycleII {
	 public ListNode detectCycle(ListNode head) {
	        if(head == null || head.next == null){
	        	return null;
	        }
	        
	        ListNode h1 = head;
	        ListNode h2 = head;
	        
	        while(h2 != null && h2.next != null){
	        	h1 = h1.next;
	        	h2 = h2.next.next;
	        	if(h1 == h2){
	        		break;
	        	}
	        }
	        if(h2 == null || h2.next == null) {
	        	return null;
	        }
	        
	        h1 = head;
	        while(h1 != h2){
	        	h1 = h1.next;
	        	h2 = h2.next;
	        }
	        return h1;
	    }
}
