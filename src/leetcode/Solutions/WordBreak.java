package leetcode.Solutions;

import java.util.HashMap;
import java.util.Set;

public class WordBreak {
	 public boolean wordBreak(String s, Set<String> dict) {
	        if(s == null || s.length() == 0){
	        	return true;
	        }
	        HashMap<String, Boolean> table = new HashMap<String, Boolean>();
	        return isWord(s,table, dict);
	    }
	    private boolean isWord(String s, HashMap<String, Boolean> table, Set<String> dict){
	    	if(table.containsKey(s)){
	    		return table.get(s);
	    	}
	    	
	    	if(s.isEmpty() || dict.contains(s)){
	    		return true;
	    	}
	    	
	    	for(int i=1; i<=s.length(); i++){
	    		if(dict.contains(s.substring(0,i))){
	    			if(isWord(s.substring(i),table,dict)){
	    				table.put(s, true);
	    				return true;
	    			}
	    		}
	    	}
	    	table.put(s,false);
	    	return false;
	    }
}
