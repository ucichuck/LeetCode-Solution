package leetcode.Solutions;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
        if(S.length()==0 && T.length()!=0){
            return 0;
        }
        int[][] arr = new int[T.length()+1][S.length()+1];
        arr[0][0] = 1;
        for(int i=1; i<arr.length; i++){
        	arr[i][0] = 0;
        }
        
        for(int i=0; i<arr[0].length; i++){
        	arr[0][i]= 1;
        }
        
        for(int i=1; i<arr.length; i++){
        	for(int j=1; j<arr[0].length; j++){
        		if(T.charAt(i-1) != S.charAt(j-1)){
        			arr[i][j] = arr[i][j-1];
        		}else{
        			arr[i][j] = arr[i-1][j-1] + arr[i][j-1];
        		}
        	}
        }
        return arr[T.length()][S.length()];
    }
}
