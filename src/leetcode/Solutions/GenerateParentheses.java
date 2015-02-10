package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n <= 0){
        	return res;
        }
        cal(res,n,n, "");
        return res;
    }
    private void cal(List<String> res, int left, int right, String tmp){
    	if(left == 0 && right ==0){
    		res.add(tmp);
    	}
    	
    	if(left > 0){
    		cal(res,left-1,right,tmp+"(");
    	}
    	
    	if(right > 0 && right > left){
    		cal(res,left,right-1,tmp+")");
    	}
    }
}
