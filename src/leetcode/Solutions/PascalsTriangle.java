package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows <= 0){
    		return res;
    	}
    	List<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(1);
    	res.add(tmp);
    	while(numRows > 1){
    		List<Integer> tmp2 = new ArrayList<Integer>();
    		tmp2.add(1);
    		for(int i=1; i<tmp.size(); i++){
    			int cur = tmp.get(i)+tmp.get(i-1);
    			tmp2.add(cur);
    		}
    		tmp2.add(1);
    		res.add(tmp2);
    		tmp = tmp2;
    	}
    	return res;
    }
}
