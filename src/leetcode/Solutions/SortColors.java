package leetcode.Solutions;

public class SortColors {
	public void sortColors(int[] A) {
        if(A == null || A.length == 0){
        	return;
        }
        
        int cur = 0;
        int left = 0;
        int right = A.length-1;
        
        while(cur <= right){
        	if(A[cur] == 2){
        		A[cur] = A[right];
        		A[right] = 2;
        		right--;
        	}else if(A[cur] == 1){
        		cur ++;
        	}else{
        		A[cur] = A[left];
        		A[left] = 0;
        		left++;
        		cur++;
        	}
        }
        		
    }
}
