package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
        if(n == 0){
        	res.add(0);
        	return res;
        }
        
        List<Integer> tmp = grayCode(n-1);
        
        for(int i=0; i<tmp.size(); i++){
        	int cur = tmp.get(i);
        	if(i%2 == 0){
        		res.add(cur*2);
        		res.add(cur*2+1);
        	}else{
        		res.add(cur*2+1);
        		res.add(cur*2);
        	}
        }
        return res;
    }
}
