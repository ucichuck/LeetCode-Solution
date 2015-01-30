package leetcode.Solutions;

public class AddBinary {
	 public String addBinary(String a, String b) {
	        if(a.isEmpty()){
	        	return b;
	        }else if(b.isEmpty()){
	        	return a;
	        }
	        
	        int lena = a.length()-1;
	        int lenb = b.length()-1;
	        int carry = 0;
	        String res = "";
	        for(;lena>=0 || lenb >=0; lena--, lenb--){
	        	int aa = 0;
	        	if(lena >= 0){
	        		aa = a.charAt(lena)-'0';
	        	}
	        	int ba = 0;
	        	if(lenb >= 0){
	        		ba = b.charAt(lenb)-'0';
	        		
	        	}
	        	int sum = aa + ba +carry;
	        	res= sum%2 + res;
	        	carry = sum/2;
	        }
	        if(carry != 0){
	        	res = carry + res;
	        }
	        return res;
	    }
}
