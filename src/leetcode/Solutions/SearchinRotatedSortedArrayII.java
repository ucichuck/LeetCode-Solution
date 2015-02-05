package leetcode.Solutions;

public class SearchinRotatedSortedArrayII {
	 public boolean search(int[] A, int target) {
	        if(A.length == 0){
	        	return false;
	        }
	        
	        return sea(A, target, 0, A.length-1);
	    }
	    private boolean sea(int[] A, int target, int left, int right){
	    	if(left > right){
	    		return false;
	    	}
	    	int mid = (left+right)/2;
	    	if(A[mid] == target){
	    		return true;
	    	}
	    	
	    	if(A[left] < A[mid]){
	    		if(target >= A[left] && target < A[mid]){
	    			return sea(A,target,left, mid-1);
	    		}else{
	    			return sea(A,target,mid+1,right);
	    		}
	    	}else if(A[left] > A[mid]){
	    		if(target <= A[right] && target > A[mid]){
	    			return sea(A,target,mid+1,right);
	    		}else{
	    			return sea(A,target,left, mid-1);
	    		}
	    	}else{
	    		if(A[right] != A[mid]){
	    			return sea(A,target,mid+1,right);
	    		}else{
	    			return sea(A,target,mid+1,right) || sea(A,target,left, mid-1);
	    		}
	    	}
	    }
}
