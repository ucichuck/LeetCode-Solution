package leetcode.Solutions;

public class Sqrtx {
	public int sqrt(int x) {
        if(x <= 0){
        	return -1;
        }
        if(x == 1){
        	return x;
        }
        
        long left = 1;
        long right = x;
        while(left <= right){
        	long mid = (left+right)/2;
        	if(mid*mid <= x && (mid+1)*(mid+1) > x){
        		return (int)mid;
        	}else if(mid*mid > x){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        return -1;
    }
}
