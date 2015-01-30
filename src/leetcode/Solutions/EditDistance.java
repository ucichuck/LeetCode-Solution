package leetcode.Solutions;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
        	return word2.length();
        }else if(word2.length() == 0){
        	return word1.length();
        }
        
        int[][] arr = new int[word1.length()+1][word2.length()+1];
        
        for(int i=0; i<=word1.length(); i++){
        	for(int j=0; j<=word2.length(); j++){
        		if(i == 0 && j == 0){
        			arr[i][j] = 0;
        		}else if( i == 0){
        			arr[i][j] = arr[i][j-1]+1;
        		}else if( j == 0){
        			arr[i][j] = arr[i-1][j]+1;
        		}else if(word1.charAt(i-1) == word2.charAt(j-1)){
        			arr[i][j] = arr[i-1][j-1];
        		}else{
        			arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
        		}
        	}
        }
        return arr[word1.length()][word2.length()];
    }
}
