package leetcode.Utility;

public class FourListNode {
	public FourListNode up;
	public FourListNode down;
	public FourListNode pre;
	public FourListNode next;
	public int val;
	
	public FourListNode(int val){
		this.val = val;
	}
	public void set(FourListNode up, FourListNode down, FourListNode pre, FourListNode next){
		this.up = up;
		this.down = down;
		this.pre = pre;
		this.next = next;
	}
}
