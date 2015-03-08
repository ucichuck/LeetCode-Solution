package leetcode.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoWords {
	private HashMap<String,List<Integer>> map ;
	
	public TwoWords(String[] arr){
		map = new HashMap<String,List<Integer>>();
		
		for(int i=0; i<arr.length; i++){
			String tmp = arr[i];
			List<Integer> listIndex ;
			if(map.containsKey(tmp)){
				listIndex = map.get(tmp);
			}else{
				listIndex = new ArrayList<Integer>();
			}
			
			listIndex.add(i);
			map.put(tmp, listIndex);
		}
	}
	
	public int minDis(String k1, String k2){
		List<Integer> k1Indexes = map.get(k1);
		List<Integer> k2Indexes = map.get(k2);
		
		if(k1Indexes == null || k2Indexes == null){
			return Integer.MAX_VALUE;
		}
		
		int i1 = 0;
		int i2 = 0;
		int min = Integer.MAX_VALUE;
		while(i1 <k1Indexes.size() && i2 < k2Indexes.size()){
			int a = k1Indexes.get(i1);
			int b = k2Indexes.get(i2);
			if(a >= b){
				int dif = a - b;
				if(dif < min){
					min = dif;
				}
				i2++;
			}else{
				int dif = b-a;
				if(dif < min){
					min = dif;
				}
				i1++;
			}
			
		}
		return min;
	}
}
