package leetcode.Solutions;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
        	return digits;
        }
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
        	int sum = digits[i]+carry;
        	carry = sum / 10;
        	digits[i] = sum%10;
        	if(carry == 0){
        		return digits;
        	}
        }
        
        int[] res = new int[digits.length+1];
        for(int i=0; i<res.length; i++){
        	if(i == 0){
        		res[i] = 1;
        	}else{
        		res[i] = digits[i-1];
        	}
        }
        return res;
    }
}
