package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
        	return false;
        }
        
        ListNode h1 = head;
        ListNode h2 = head;
        while(h2 != null && h2.next != null){
        	h1 = h1.next;
        	h2 = h2.next.next;
        	if(h1 == h2){
        		return true;
        	}
        }
        return false;
    }
}
