package leetcode.Solutions;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
        	return;
        }
        
        int[] arr = new int[matrix.length];
        int[] arr2 = new int[matrix[0].length];
        boolean izero = false;
        boolean jzero = false;
        for(int i=0; i<matrix.length; i++){
        	if(matrix[i][0] == 0){
        		arr[i] = 1;
        		izero = true;
        	}
        }
        
        for(int j=0; j<matrix[0].length; j++){
        	if(matrix[0][j] == 0){
        		arr2[j] = 1;
        		jzero = true;
        	}
        }
        
        for(int i=1; i<matrix.length; i++){
        	for(int j = 1; j<matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			arr[i] = 1;
        			arr2[j] = 1;
        		}
        	}
        }
        
        for(int i=0; i<matrix.length; i++){
        	for(int j = 0; j<matrix[0].length; j++){
        		if(izero && j == 0){
        				matrix[i][j] = 0;
        		}else if(jzero && i == 0){
        			matrix[i][j] = 0;
        		}else if(arr[i] == 1 || arr2[j] == 1){
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
}
