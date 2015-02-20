package leetcode.Solutions;

public class FindPeakElement {
	 public int findPeakElement(int[] num) {
	    	if (num == null) {
	            return 0;
	        }
	        
	        if (num.length == 1) {
	            return 0;
	        }
	        
	      return get(num,0,num.length-1);
	    }
	    private int get(int[] num, int left, int right){
	    	if(left == right){
	    		return left;
	    	}
	    	int mid = (left+right)/2;
	    	int mid2 = mid+1;
	    	if(num[mid] > num[mid2]){
	    		return get(num,left,mid);
	    	}else{
	    		return get(num,mid2,right);
	    	}
	    }
	    
	public int findPeakElement2(int[] num) {
      if(num.length == 0){
      	return -1;
      }
      
      int left = 0;
      int right = num.length-1;
      while(left < right){  // right != mid -1 时， 不能用 《= 判断
      	int mid = (left+right)/2;
      	
      	if(num[mid] <num[mid+1]){// 有溢出的约束时 用这个方法效果很好
      		left = mid+1;
      	}else{
      		right = mid; 
      	}
      }
      return left;
	}
}
