package leetcode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] A, int start, int end) {
        List<String> ranges = new ArrayList<String>();
        int prev = start - 1;
        for (int i=0; i<=A.length; ++i) {
            int curr = (i==A.length) ? end + 1 : A[i];
            if ( curr-prev>=2 ) {
                ranges.add(getRange(prev+1, curr-1));
            }
            prev = curr;
        }
        return ranges;
    }
 
    private String getRange(int from, int to) {
        return (from==to) ? String.valueOf(from) : from + "->"+ to;
    }
}
