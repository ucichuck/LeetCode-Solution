package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(n < k){
    		return res;
    	}
    	List<Integer> tmp = new ArrayList<Integer>();
    	cal(n,k,0,tmp,res);
    	return res;
    }
    private void cal(int n, int k, int cur, List<Integer> tmp, List<List<Integer>> res){
    	if(k == 0){
    		 List<Integer> tmp2 = new ArrayList<Integer>();
    		 tmp2.addAll(tmp);
    		 res.add(tmp2);
    	}
    	if(k > (n-cur)){
    		return;
    	}
    	
    	for(int i= cur+1; i<=n; i++){
    		tmp.add(i);
    		cal(n,k-1,i,tmp,res);
    		tmp.remove(tmp.size()-1);
    	}
    	
    }
}
