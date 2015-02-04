package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || head.next == null){
    		return head;
    	}
        if(n <= 0){
        	return head;
        }
        
        ListNode p1 = head;
        ListNode p2 = head;
        while(n > 0){
        	p2 = p2.next;
        	n--;
        	if(p2 == null){
        		p2 = head;
        	}
        }
        if(p1 == p2){
        	return head;
        }
        
        while(p2.next != null){
        	p1 = p1.next;
        	p2 = p2.next;
        }
        ListNode res = p1.next;
        p1.next = null;
        p2.next = head;
        return res;
    }
}
