package leetcode.Solutions;

import java.util.HashMap;

public class RomantoInteger {
	public int romanToInt(String s) {
        HashMap<Character, Integer> table = new HashMap<Character,Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        
        if(s == null || s.length() == 0){
        	return 0;
        }
        int pre = 0; int res = 0;
        for(int i=0; i<s.length(); i++){
        	int cur = table.get(s.charAt(i));
        	if(cur <= pre){
        		res+=cur;
        	}else{
        		res += cur - pre*2;
        	}
        	pre = cur;
        }
        return res;
    }
}
