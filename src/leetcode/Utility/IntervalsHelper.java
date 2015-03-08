package leetcode.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalsHelper {
	private List<Interval> listIntervals = new ArrayList<Interval>();
	
	public void addInterval(int from, int to){
		listIntervals.add(new Interval(from, to));
	}
	
	public int getTotalCoveredLength(){
		if(listIntervals.isEmpty()){
			return 0;
		}
		Collections.sort(listIntervals, new MyComparator());
		
		Interval pre = listIntervals.get(0);
		int res = 0;
		boolean isoverlap = false;
		for(int i=1; i<listIntervals.size(); i++){
			Interval cur = listIntervals.get(i);
			
			if(cur.start > pre.end){
				pre = cur;
				isoverlap = false;
				continue;
			}else{
				int maxEnd = Math.max(cur.end, pre.end);
				if(isoverlap){
					res+= maxEnd - pre.end;
				}else{
					res += maxEnd - pre.start + 1;
				}
				isoverlap = true;
				pre = new Interval(pre.start, maxEnd);
			}
		}
		
		return res;
	}
	
	public class MyComparator implements Comparator<Interval>{
		public int compare(Interval i1, Interval i2){
			return i1.start - i2.start;
		}
	}
}
