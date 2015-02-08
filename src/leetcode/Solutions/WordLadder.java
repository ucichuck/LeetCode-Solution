package leetcode.Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
        HashSet<String> visited = new HashSet<String>();
        ArrayList<String> curr = new ArrayList<String>();
        ArrayList<String> nexts = new ArrayList<String>();
        
        curr.add(start);
        int count = 1;
        
        while(!curr.isEmpty()){
        	String tmp = curr.remove(0);
        	ArrayList<String> changedKey = get(tmp, dict, visited);
        	for(String newKey : changedKey){
        		if(newKey.equals(end)){
        			return count+1;
        		}else{
        			nexts.add(newKey);
        		}
        	}
        	if(curr.isEmpty()){
        		curr = nexts;
        		count ++;
        		nexts = new ArrayList<String>();
        	}
        }
        return 0;
    }
    
    private  ArrayList<String> get(String tmp, Set<String> dict, HashSet<String> visited){
    	ArrayList<String> res = new ArrayList<String>();
    	char[] arr = tmp.toCharArray();
    	for(int i=0; i<tmp.length(); i++){
    		char currentChar = tmp.charAt(i);
    		for(char a = 'a'; a<='z'; a++){
    			if(a != currentChar){
    				arr[i] = a;
    				String convert = new String(arr);
    				if(dict.contains(convert) && !visited.contains(convert)){
    					res.add(convert);
    					visited.add(convert);
    				}
    				arr[i] = currentChar;
    			}
    		}
    		
    	}
    	return res;
    }
}
