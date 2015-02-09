package leetcode.Solutions;

import java.util.ArrayList;

public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> res = new ArrayList<String>();
    	
    	if(s == null || s.length() == 0){
    		return res;
    	}
    	
    	getIP(s, 0, 0, "",res);
    	return res;
    }
    public void getIP(String s, int index, int n, String cur, ArrayList<String> res){

    	if(s.length() == index && n == 4){
    		res.add(cur);
    		
    		return;
    	}
    	
    	if((s.length()-(index))>(4-n)*3){
    		return ;
    	}
    	
    	if((s.length()-(index) )< (4-n)){
    		return;
    	}  	
    	
    	for(int i = index; i<= index+2 && i<s.length(); i++){
    		String key = s.substring(index,i+1);
    		int value = Integer.valueOf(key);
    		if(value >= 0 && value <= 255){
    			String newS = cur.equals("")? key : cur+"."+key;
    			getIP(s,i+1,n+1,newS,res);
    		}
    		if(value == 0){
    		    break;
    		}
    	}
    }
}
