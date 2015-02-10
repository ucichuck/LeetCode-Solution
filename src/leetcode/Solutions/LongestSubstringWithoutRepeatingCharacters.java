package leetcode.Solutions;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
        	return 0;
        }
        
        HashMap<Character,Integer> table = new HashMap<Character,Integer>();
        int left = 0;;
        int cur = 0;
        int max = 0;
        for(;cur<s.length(); cur++){
        	char tmp = s.charAt(cur);
        	if(!table.containsKey(tmp)){
        		table.put(tmp, cur);
        	}else{
        		max = Math.max(max, cur-left);
        		int newLeft = table.get(tmp)+1;
        		for(int i = left; i<newLeft; i++){
        			table.remove(s.charAt(i));  // !!!shuold clean hashmap
        		}
        		left = newLeft;
        		table.put(tmp,cur);
        	}
        }
        max = Math.max(max, cur-left);
        return max;
    }
}
