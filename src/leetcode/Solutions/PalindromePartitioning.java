package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
    	List<List<String>> list = new ArrayList<List<String>>();
    	List<String> li = new ArrayList<String>();
        if(s == null || s.isEmpty()){
        	li.add("");
        	list.add(li);
        	return list;
        }
        
        split(s, list, li);
        return list;
        
        
    }
    
    private void split(String s, List<List<String>> list, List<String> li ){
    	if(s.isEmpty()){
    		 List<String> li2 = new ArrayList<String>();
    		 li2.addAll(li);
    		list.add(li2);
    	}
    	
    	for(int i=1; i<=s.length(); i++){
    		String cur = s.substring(0,i);
    		if(isPal(cur)){
    			li.add(cur);
    			split(s.substring(i),list,li);
    			li.remove(li.size()-1);
    		}
    	}
    }
    
    private boolean isPal(String cur){
    	if(cur.length()<=1){
    		return true;
    	}
    	int left = 0;
    	int right = cur.length()-1;
    	while(left < right){
    		if(cur.charAt(left) != cur.charAt(right)){
    			return false;
    		}
    		left ++;
    		right --;
    	}
    	return true;
    }
}
