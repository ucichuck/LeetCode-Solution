package leetcode.Solutions;

public class SpiralMatrixII {
	 public int[][] generateMatrix(int n) {
	        if(n <= 0){
	        	return null;
	        }
	        int[][] res = new int[n][n];
	        int count = 1;
	        int k = n;
	        int l = n;
	        int x = 0;
	        int y = 0;
	        while(k >0 && l > 0){
	        	if(k == 1){
	        		for(int i=0; i<l; i++){
	        			res[x][y++] = count++;
	        		}
	        		break;
	        	}else if(l == 1){
	        		for(int i =0; i<k; i++){
	        			res[x++][y] = count++;
	        		}
	        		break;
	        	}
	        	
	        	for(int i=0; i<l-1; i++){
	        		res[x][y++] = count++;
	        	}
	        	
	        	for(int i=0; i<k-1; i++){
	        		res[x++][y] = count++;
	        	}
	        	
	        	for(int i=0; i<l-1; i++){
	        		res[x][y--] = count++;
	        	}
	        	
	        	for(int i=0; i<k-1; i++){
	        		res[x--][y] = count++;
	        	}
	        	
	        	x++;
	        	y++;
	        	k = k-2;
	        	l = l-2;
	        }
	        return res;
	    }
}
