package leetcode.Solutions;

import java.util.HashMap;

import leetcode.Utility.Point;

public class MaxPointsonaLine {
	 public int maxPoints(Point[] points) {
	        if(points.length < 2){
	        	return points.length;
	        }
	        
	        int max = 0;
	        for(int i=0; i<points.length; i++){
	        	Point cur = points[i];
	        	int duplicate = 1;
	        	HashMap<Double,Integer> map = new HashMap<Double,Integer>();
	        	for(int j=0; j<points.length; j++){
	        		if(i == j){
	        			continue;
	        		}
	        		
	        		Point tmp = points[j];
	        		double slope = 0.0;
	        		if(tmp.x == cur.x && tmp.y == cur.y){
	        			duplicate ++;
	        			continue;
	        		}else if(tmp.x == cur.x){
	        			slope = Integer.MAX_VALUE;
	        		}else{
	        			slope = cur.y == tmp.y ? 0 : 1.0*(cur.y-tmp.y)/(cur.x-tmp.x);
	        		}
	    			if(!map.containsKey(slope)){
	    				map.put(slope, 0);
	    			}
	    			map.put(slope, map.get(slope)+1);
	        	}
	        	
	        	if(map.keySet().isEmpty()){
	        		max = Math.max(max, duplicate);
	        	}else{
	        		for(double key : map.keySet()){
	        			max = Math.max(max, duplicate+map.get(key));
	        		}
	        	}
	        }
	        return max;
	    }
}
