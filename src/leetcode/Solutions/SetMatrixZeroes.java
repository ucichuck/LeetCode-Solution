package leetcode.Solutions;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
        	return;
        }
        
        int[] is = new int[matrix.length];
        int[] js = new int[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			is[i] = 1;
        			js[j] = 1;
        		}
        		
        	}
        }
        
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(is[i] == 1 || js[j] == 1){
        			matrix[i][j] = 0;
        		}
        		
        	}
        }
    }
}
