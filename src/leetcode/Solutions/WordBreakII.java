package leetcode.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
    	List<String> res = new ArrayList<String>();
    	if(s == null || s.isEmpty()){
    		return res;
    	}
    	
    	HashMap<String, List<String>> table = new HashMap<String, List<String>>();
    	
    	return getWord(s,dict,table);   	
    }
    
    private List<String> getWord(String s, Set<String> dict, HashMap<String, List<String>> table){
    	List<String> res = new ArrayList<String>();
    	if(table.containsKey(s)){
    		return table.get(s);
    	}
    	
    	if(s.isEmpty()){
    		return res;
    	}
    	
    	if(dict.contains(s)){
    		res.add(s);
    	}
    	
    	for(int i=1; i<=s.length(); i++){
    		String tmp = s.substring(0,i);
    		if(dict.contains(tmp)){
    			List<String> next = getWord(s.substring(i),dict,table);
    			if(!next.isEmpty()){
    				for(String ss : next){
    					res.add(tmp+" "+ss);
    				}
    			}
    		}
    	}
    	table.put(s, res);
    	return res;
    }
}
