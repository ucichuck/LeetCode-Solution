package leetcode.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DNA {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
    	
        if(s == null || s.length() < 10){
        	return res;
        }
        Map<Character,Integer> numbers = new HashMap<Character, Integer>();
        numbers.put('A', 0);
        numbers.put('C', 1);
        numbers.put('G', 2);
        numbers.put('T', 3);
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> unique = new HashSet<Integer>();
        
        int cur = 0;
        while((cur+9)< s.length()){
        	int k = 0;
        	for(int i=0; i<10; i++){
        		k = k*4+numbers.get(s.charAt(cur+i));
        	}
        	
        	if(set.contains(k) && !unique.contains(k)){
        		unique.add(k);
        		res.add(s.substring(cur,cur+10));
        	}else{
        		set.add(k);
        	}
        	cur++;
        }
        
        
        return res;
    }
}
