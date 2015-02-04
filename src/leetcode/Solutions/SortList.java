package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
        	pre = pre.next;
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        
        pre.next = null;
        return merge(sortList(head), sortList(p1));
    }
    private ListNode merge(ListNode p1, ListNode p2){
    	ListNode pre = new ListNode(-1);
    	ListNode res = pre;
    	while(p1 != null && p2 != null){
    		if(p1.val < p2.val){
    			pre.next = p1;
    			p1 = p1.next;
    		}else{
    			pre.next = p2;
    			p2 = p2.next;
    					
    		}
    		pre = pre.next;
    	}
    	if(p1 != null){
    		pre.next = p1;
    	}
    	if(p2 != null){
    		pre.next = p2;
    	}
    	return res.next;
    }
}
