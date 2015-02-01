package leetcode.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
	HashSet<List<Integer>> table = new HashSet<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	if(num.length == 0){
    		res.add(tmp);
    		return res;
    	}
    	
    	get(num, 0, tmp, res);
    	return res;
    }
    private void get(int[] num, int index, List<Integer> tmp,List<List<Integer>> res ){
    	if(index == num.length){
    		
    		if(!table.contains(tmp)){
    			List<Integer> tmp2 = new ArrayList<Integer>();
        		tmp2.addAll(tmp);
        		res.add(tmp2);
        		table.add(tmp2);
        		return;
    		}
    		
    	}
    	
    	for(int i= index; i<num.length; i++){
    		tmp.add(num[i]);
    		get(num,i+1,tmp,res);
    		tmp.remove(tmp.size()-1);
    		get(num,i+1,tmp,res);
    	}
    }
}
