package leetcode.Solutions;

import leetcode.Utility.RandomListNode;

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
        	return null;
        }
        RandomListNode cur = head;
       while(cur != null ){
    	   RandomListNode next = cur.next;
    	   RandomListNode tmp = new RandomListNode(cur.label);
    	   cur.next = tmp;
    	   tmp.next = next;
    	   cur = next;
       }
       
       cur = head;
       while(cur != null){
    	   RandomListNode ran = cur.random;
    	   if(ran != null){
    	      cur.next.random = cur.random.next;
    	   
    	   }
    	   cur = cur.next.next; 
       }
       
       cur = head;
       RandomListNode res = new RandomListNode(-1);
       res.next = cur.next;
       while(cur != null){
    	   RandomListNode next = cur.next.next;
    	   RandomListNode copy = cur.next;
    	   cur.next = next;
    	   if(next == null){
    		   copy.next = null;
    		   break;
    	   }else{
    		   copy.next = next.next;
    	   }
    	   cur = next;
       }
       
       return res.next;
       
        
    }
}
