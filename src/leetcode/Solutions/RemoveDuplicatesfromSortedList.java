package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        
        ListNode cur = head;
        while(cur.next != null){
        	ListNode next = cur.next;
        	if(next.val != cur.val){
        		cur = next;
        	}else{
        		cur.next = next.next;
        	}
        }
        return head;
    }
}
