package leetcode.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.Utility.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null ||intervals.size()== 0){
        	return intervals;
        }
        
        Collections.sort(intervals, new TmpComparator());
        List<Interval> res = new ArrayList<Interval>();
        Interval cur = intervals.get(0);
        for(int i=1; i<intervals.size(); i++ ){
        	Interval tmp = intervals.get(i);
        	if(cur.end < tmp.start){
        		res.add(cur);
        		cur = tmp;
        	}else{
        		cur.end = Math.max(cur.end, tmp.end);
        	}
        }
        res.add(cur);
        return res;
    }
    private class TmpComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval t1, Interval t2) {
			if(t1.start < t2.start){
				return -1;
			}else if(t1.start == t2.start){
				return 0;
			}else{
				return 1;
			}
		}
    	
    }
}
