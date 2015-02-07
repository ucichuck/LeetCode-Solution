package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class IntersectionofTwoLinkedLists {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null){
	        	return null;
	        }
	        ListNode pA = headA;
	        ListNode pB = headB;
	        while(pA != null && pB != null){
	        	pA = pA.next;
	        	pB = pB.next;
	        }
	        
	        while(pA != null){
	        	pA = pA.next;
	        	headA = headA.next;
	        }
	        
	        while(pB != null){
	        	pB = pB.next;
	        	headB = headB.next;
	        }
	        
	    	while(headA != headB){
	    		headA= headA.next;
	    		headB = headB.next;
	    	}
	    	return headA;
	        
	    }
}
