package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode pre = new ListNode(-1);
    	pre.next = head;
    	ListNode res = pre;
    	
    	ListNode p1 = pre;
    	while(m > 1){
    		p1 = p1.next;
    		m--;
    	}
    	ListNode p2 = pre;
    	while(n > 1){
    		p2 = p2.next;
    		n--;
    	}
    	p2 = p2.next;
    	ListNode cur = p1.next;
    	ListNode post = cur.next;
    	while(cur != p2){
    		ListNode next = post.next;
    		post.next = cur;
    		cur = post;
    		post = next;
    	}
    	
    	ListNode tmp = p1.next;
    	tmp.next = post;
    	p1.next = cur;
    	
    	return res.next;
    }
}
