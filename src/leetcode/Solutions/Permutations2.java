package leetcode.Solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {
	private HashSet<List<Integer>> table = new HashSet<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0){
        	return res;
        }
        
        return insert(num,0);
    }
    private List<List<Integer>> insert(int[] num, int index){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(index == num.length){
    		List<Integer> tmp = new ArrayList<Integer>();
    		res.add(tmp);
    		return res;
    	}
    	
    	res = insert(num, index+1);
    	List<List<Integer>> res2 = new ArrayList<List<Integer>>();
    	for(List<Integer> cur : res){
    		for(int i=0; i<=cur.size(); i++){
    			List<Integer> tmp = new ArrayList<Integer>();
    			tmp.addAll(cur);
    			tmp.add(i, num[index]);
    			if(!table.contains(tmp)){
    				table.add(tmp);
    				res2.add(tmp);
    			}
    		}
    	}
    	return res2;
    }
}
