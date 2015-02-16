package leetcode.Solutions;

public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        
        if(A == null){
        	return res;
        }
       
        int left =0;
        int right = A.length-1;
        while(left <= right){
        	int mid = (left+right)/2;
        	if(A[mid] == target){
        		if(mid > 0 && A[mid-1] == target){
        			right = mid-1;
        		
        		}else{
        			res[0] = mid;
        			break;
        		}
        	}else if(A[mid] > target){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        
        left =0;
        right = A.length-1;
        while(left <= right){
        	int mid = (left+right)/2;
        	if(A[mid] == target){
        		if(mid < A.length-1 && A[mid+1] == target){
        			left = mid+1;
        		}else{
        			res[1] = mid;
        			break;
        		}
        	}else if(A[mid] > target){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        
        return res;
    }
}
