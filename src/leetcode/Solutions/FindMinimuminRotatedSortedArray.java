package leetcode.Solutions;

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] num) {
        if(num.length == 0){
        	return -1;
        }
        int left = 0;
        int right = num.length-1;
        while(left <= right){
        	int mid = (left+right)/2;
        	if(num[mid] > num[right]){
        		left = mid +1;
        	}else{
        		right = mid - 1;
        	}
        }
        return left;
    }
}
