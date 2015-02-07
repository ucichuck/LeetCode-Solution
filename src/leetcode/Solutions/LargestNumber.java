package leetcode.Solutions;

import java.util.Arrays;
import java.util.Comparator;

import leetcode.Solutions.Solution.MySort;

public class LargestNumber {
	public String largestNumber(int[] num) {
        int len = num.length;
        String array[] = new String[len];
        for (int i = 0; i < len; i++) {
            array[i] = String.valueOf(num[i]);
        }
        Arrays.sort(array, new MySort());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(array[i]);
        }
        String result = sb.toString();
        if ("".equals(result.replace("0",""))) {
            return "0";
        }
        return sb.toString();
    }

    public class MySort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }
}
