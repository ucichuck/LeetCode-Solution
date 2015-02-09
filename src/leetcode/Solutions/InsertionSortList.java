package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-2147483648);
        ListNode p1 = dummyHead, p2 = head;
        
        while(p2 != null){
            ListNode pre = findInsertPlace(p1, p2);
            // insert into list
            // save orignal list next node
            ListNode originalNext = p2.next;
            p2.next = pre.next;
            pre.next = p2;
            
            p2 = originalNext;
        }
        
        return dummyHead.next;
    }
    
    public ListNode findInsertPlace(ListNode p1, ListNode p2){
        ListNode pre = null, cur = p1;
        while(cur != null && cur.val <= p2.val){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}
