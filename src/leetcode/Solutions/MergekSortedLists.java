package leetcode.Solutions;

import java.util.List;

import leetcode.Utility.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.isEmpty()){
        	return null;
        }
        
        int left = 0;
        int right = lists.size()-1;
        
        while(right >0){
        	while(left < right){
        		lists.set(left, merge(lists,left,right));
        		right--;
        		left++;
        	}
        	left = 0;
        }
        return lists.get(0);
    }
    
    private ListNode merge(List<ListNode> lists, int left, int right){
    	ListNode pre = new ListNode(-1);
    	ListNode res = pre;
    	ListNode a =lists.get(left);
    	ListNode b = lists.get(right);
    	
    	while(a != null && b != null){
    		if(a.val < b.val){
    			pre.next = a;
    			a = a.next;
    		}else{
    			pre.next = b;
    			b = b.next;
    			
    		}
    		pre = pre.next;
    	}
    	if(a != null){
    		pre.next =a;
    	}else if(b != null){
    		pre.next = b;
    	}
    	return res.next;
    }
}
