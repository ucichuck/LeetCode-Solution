package leetcode.Solutions;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int len = m+n-1;
        for(;n>0;len--){
        	if(m == 0){
        		A[len] = B[n-1];
        		n--;
        	}else{
        		if(A[m-1] > B[n-1]){
        			A[len] = A[m-1];
        			m--;
        		}else{
        			A[len] = B[n-1];
        			n--;
        		}
        	}
        }
    }
}
