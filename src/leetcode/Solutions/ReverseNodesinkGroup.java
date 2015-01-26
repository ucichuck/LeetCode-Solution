package leetcode.Solutions;

public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
        	return head;
        }
        
       int size = 0;
       ListNode cur = head;
       while(cur != null){
    	   cur = cur.next;
    	   size ++;
       }
       
       int loop = size / k;
       cur = head;
       ListNode res = new ListNode(-1);
       res.next = head;
       ListNode pre = res;
      
       
       for(int i=0; i<loop; i++){
    	   int j = 0;
    	   ListNode post = cur.next;
    	   while(post != null){
    		   ListNode next = post.next;
    		   post.next = cur;
    		   cur = post;
    		   post = next;
    		   j++;
    		   if(j == k-1){
    			   ListNode tmp = pre.next;
    			   pre.next = cur;
    			   tmp.next = post;
    			   pre = tmp;
    			   cur = pre.next;
    			   break;
    		   }
    	   }
       }
       
       return res.next;
        
    }
}
