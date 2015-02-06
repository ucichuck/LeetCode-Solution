package leetcode.Solutions;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len =A.length;
        if(len==1){
            return 1;
        }else if(len<=0){
            return 0;
        }
        int count=1;
        int cur=A[0];
        int b=1;
        int resLen =0;
        for(int i=1; i<len; i++){
            if(cur==A[i]){
                if(count<2){
                    count++;
                    A[b]=A[i];
                    b++;
                }
            }else{
                A[b]=A[i];
                cur=A[i];
                b++;
                count=1;
            }
        }
        
        return b;
        
    }
}
