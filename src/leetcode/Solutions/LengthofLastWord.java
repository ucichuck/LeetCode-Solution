package leetcode.Solutions;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int end = s.length()-1;
        while(end >= 0){
        	if(s.charAt(end)==' '){
        		end --;
        	}else{
        		break;
        	}
        }
        if(end < 0){
        	return 0;
        }
        
        int count = 0;
        while(end >=0 ){
        	if(s.charAt(end) != ' '){
        		end--;
        		count++;
        	}else{
        		break;
        	}
        }
        return count;
    }

}
