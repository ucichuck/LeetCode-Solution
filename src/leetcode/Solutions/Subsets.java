package leetcode.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	 public List<List<Integer>> subsets(int[] S) {
	        Arrays.sort(S);
	    	List<List<Integer>> res = new ArrayList<List<Integer>>();
	    	if(S == null || S.length == 0){
	    		return res;
	    	}
	    	
	    	List<Integer> tmp = new ArrayList<Integer>();
	    	cal(S, 0, tmp, res);
	    	return res;
	    }
	    
	    private void cal(int[] S, int index, List<Integer> tmp, List<List<Integer>> res){
	    	if(index == S.length){
	    		List<Integer> tmp2 = new ArrayList<Integer>();
	    		tmp2.addAll(tmp);
	    		res.add(tmp2);
	    		return;
	    	}
	    	
	    		cal(S,index+1,tmp,res);
	    		tmp.add(S[index]);
	    		cal(S,index+1,tmp,res);
	    		tmp.remove(tmp.size()-1);
	    	
	    }
}
