package leetcode.Solutions;

public class MaximumGap {
	public int maximumGap(int[] num) {
        if(num == null || num.length < 2) return 0;
     
     int min = num[0], max = num[0];
     int len = num.length;
     for(int i=1; i<len; i++) {
         if(num[i] < min) {
             min = num[i];
         } else if(num[i] > max) {
             max = num[i];
         }
     }
     if(len==2) return max - min;
     int [] min_bs = new int[len+1];
     int [] max_bs = new int[len+1];
     
     for(int i=0; i<len; i++) {
         int x = num[i];
         int k =  (int)(len * (1.0 * (x - min) / (max - min))); //attention! may have overflow problem!
         if(min_bs[k]==0 || x<min_bs[k]) min_bs[k] = x;
         if(max_bs[k]==0 || x>max_bs[k]) max_bs[k] = x;
     }
     
     int maxInter = 0;
     min = max_bs[0];
     for(int i=1; i<len+1; i++) {
         if(min_bs[i] == 0) continue;
         maxInter = Math.max(maxInter, min_bs[i] - min);
         min = max_bs[i];
     }
     return maxInter;
     
 }
}
