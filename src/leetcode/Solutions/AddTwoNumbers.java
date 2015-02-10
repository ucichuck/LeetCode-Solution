package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
        	return l1;
        }
        
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        int carry = 0;
        while(l1 != null || l2 != null){
        	int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) +carry;
        	
        	ListNode tmp = new ListNode(sum%10);
        	carry = sum / 10;
        	pre.next = tmp;
        	pre = tmp;
        	if(l1 != null){
        		l1 = l1.next;
        	}
        	if(l2 != null){
        		l2 = l2.next;
        	}
        	
        }
        if(carry > 0){
        	ListNode tmp = new ListNode(carry);
        	pre.next = tmp;
        }
        return res.next;
    }
}
