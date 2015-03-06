package leetcode.Utility;

import java.util.List;

public class NestedInteger {
	private Integer val;
	private List<NestedInteger> listVal;
	public boolean isInteger(){
		return getVal() != null;
	}
	
	
	public Integer getVal() {
		return val;
	}
	public void setVal(Integer val) {
		this.val = val;
	}
	public List<NestedInteger> getListVal() {
		return listVal;
	}
	public void setListVal(List<NestedInteger> listVal) {
		this.listVal = listVal;
	}
}
