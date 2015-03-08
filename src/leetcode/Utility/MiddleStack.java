package leetcode.Utility;

public class MiddleStack {
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode mid;
	private int count;
	
	public MiddleStack(){
		count = 0;
	}
	public void push(int val){
		DoubleLinkedListNode cur = new DoubleLinkedListNode();
		cur.val = val;
		
		if(count == 0){
			head = cur;
			mid = cur;
			count ++;
			
		}else{
			cur.pre = null;
			cur.next = head;
			head.pre = cur;
			head = cur;
			count ++;
			if(count %2 == 1 ){
				mid = mid.pre;
			}
		}
	}
	
	public int pop(){
		if(count == 0){
			throw new IllegalArgumentException("It's empty");
		}
		DoubleLinkedListNode cur  = head;
		head = head.next;
		head.pre = null;
		count--;
		if(count % 2 == 0){
			mid = mid.next;
		}
		
		return cur.val;
	}
	
	public int popMid(){
		DoubleLinkedListNode pre = mid.pre;
		DoubleLinkedListNode next = mid.next;
		if(pre != null){
			pre.next = next;
		}
		if(next != null){
			next.pre = pre;
		}
		DoubleLinkedListNode cur = mid;
		
		count --;
		if(count % 2 == 1){
			mid = pre;
		}else{
			mid = next;
		}
		return cur.val;
	}
	
	public int getMid(){
		if(mid != null){
			return mid.val;
		}
		
		return Integer.MIN_VALUE;
	}
}
