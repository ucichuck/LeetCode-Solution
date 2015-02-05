package leetcode.Solutions;

public class WordSearch {
	 public boolean exist(char[][] board, String word) {
	        int m = board.length;
	        int n = board[0].length;
	    	
	    	int[][] visit = new int[board.length][board[0].length];
	        
	        for(int i=0; i<m; i++){
	        	for(int j = 0 ; j<n; j++){
	        		if(board[i][j] == word.charAt(0)){
	        			visit[i][j] = 1;
	        			if(cal(board,i,j, visit, word.substring(1))){
	        				return true;
	        			}
	        			visit[i][j] = 0;
	        		}
	        	}
	        }
	        return false;
	    }
	    
	    private boolean cal(char[][] board, int i, int j, int[][] visit, String word){
	    	if(word.isEmpty()){
	    		return true;
	    	}
	    	
	    	if(i < 0 || i >= board.length || j<0 || j >= board[0].length){
	    		return false;
	    	}
	    	
	    	if(i>0 && visit[i-1][j] != 1 && board[i-1][j] == word.charAt(0)){
	    		visit[i-1][j] = 1;
	    		if(cal(board,i-1,j, visit, word.substring(1))){
					return true;
				}
	    		visit[i-1][j] = 0;
	    	}
	    	
	    	if(j>0 && visit[i][j-1] != 1 && board[i][j-1] == word.charAt(0)){
	    		visit[i][j-1] = 1;
	    		if(cal(board,i,j-1, visit, word.substring(1))){
					return true;
				}
	    		visit[i][j-1] = 0;
	    	}
	    	
	    	if(j<board[0].length-1 && visit[i][j+1] != 1 && board[i][j+1] == word.charAt(0)){
	    		visit[i][j+1] = 1;
	    		if(cal(board,i,j+1, visit, word.substring(1))){
					return true;
				}
	    		visit[i][j+1] = 0;
	    	}
	    	
	    	if(i<board.length-1 && visit[i+1][j] != 1 && board[i+1][j] == word.charAt(0)){
	    		visit[i+1][j] = 1;
	    		if(cal(board,i+1,j, visit, word.substring(1))){
					return true;
				}
	    		visit[i+1][j] = 0;
	    	}
	    	return false;
	    }
}
