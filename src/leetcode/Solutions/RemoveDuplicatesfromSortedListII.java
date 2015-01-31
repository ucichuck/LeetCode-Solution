package leetcode.Solutions;

import leetcode.Utility.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
	      if(head == null || head.next == null){
	    	return head;
	      }
	      
	      ListNode pre = new ListNode(-1);
	      pre.next = head;
	      ListNode res = pre;
	      boolean isDup = false;
	      
	      while(head.next != null){
	    	  ListNode next = head.next;
	    	  if(next.val == head.val){
	    		  pre.next = null;
	    		  head.next = next.next;
	    		  isDup = true;
	    		  continue;
	    	  }else{
	    		  if(!isDup){
	    			  pre = head;
	    			  head = next;
	    		  }else{
	    			  pre.next = next;
	    			  head = next;
	    		  }
	    		  isDup = false;
	    	  }
	      }
	      return res;
	    }
}
