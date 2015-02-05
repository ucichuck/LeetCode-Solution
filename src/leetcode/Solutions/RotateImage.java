package leetcode.Solutions;

public class RotateImage {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
        	return ;
        }
        int n = matrix.length;
        int k = n%2 == 0? n/2 : n/2+1;
        for(int i=0; i<n/2; i++){
        	for(int j=0; j<k; j++){
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n-1-j][i];
        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        		matrix[j][n-1-i] = tmp;
        	}
        }
        return ;
    }
}
