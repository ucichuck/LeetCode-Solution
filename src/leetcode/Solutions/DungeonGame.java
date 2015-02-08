package leetcode.Solutions;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] arr = new int[m][n];
        
        for(int i= m-1; i>=0 ; i--){
        	for(int j = n-1; j>=0; j--){
        		if(i == m-1 && j == n-1){
        			arr[i][j] = Math.max(1 - dungeon[i][j], 1);
        		}else if( i == m-1){
        			arr[i][j] = Math.max(1, arr[i][j+1] - dungeon[i][j]);
        		}else if( j == n-1){
        			arr[i][j] = Math.max(1, arr[i+1][j] - dungeon[i][j]);
        		}else{
        			arr[i][j] = Math.max(1, Math.min(arr[i+1][j], arr[i][j+1]) - dungeon[i][j]);
        		}
        	}
        }
        return arr[0][0];
    }
}
