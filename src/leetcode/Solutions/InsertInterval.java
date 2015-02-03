package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

import leetcode.Utility.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
    	if(intervals == null || intervals.size() == 0){
        	res.add(newInterval);
        	return res;
        }
    	int i=0;
    	boolean notInsert = true;
    	for( ;i<intervals.size(); i++){
    		Interval tmp = intervals.get(i);
    		if(tmp.end < newInterval.start){
    			res.add(tmp);
    		}else if(tmp.start > newInterval.end){
    			if(notInsert){
    				res.add(newInterval);
    				notInsert = false;
    			}
    			res.add(tmp);
    		}else{
    			newInterval.start = Math.min(tmp.start, newInterval.start);
    			newInterval.end = Math.max(newInterval.end, tmp.end);
    		}
    	}
    	if(notInsert){
			res.add(newInterval);
			notInsert = false;
		}
    	return res;

    }
}
