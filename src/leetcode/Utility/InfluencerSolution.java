package leetcode.Utility;

import java.util.Stack;

public class InfluencerSolution implements InfluencerFinder {
	public int getInfluencer(boolean[][] followingMatrix){
		
		if(followingMatrix == null || followingMatrix.length == 0 || followingMatrix[0].length == 0){
			throw new IllegalArgumentException("Wrong input");
		}
		int len = followingMatrix.length;
		
		Stack<Integer> persons = new Stack<Integer>();
		
		for(int i=0; i<len; i++){
			persons.push(i);
		}
		
		while(persons.size()>1){
			int i = persons.pop();
			int j = persons.pop();
			
			if(followingMatrix[i][j] == true && followingMatrix[j][i] == false){
				persons.push(j);
			}else if(followingMatrix[j][i] == true && followingMatrix[i][j] == false){
				persons.push(i);
			}
		}
		
		if(persons.size() == 0){
			throw new IllegalArgumentException("Wrong input");
		}
		
		int influncer = persons.pop();
		
		for(int i=0; i<len; i++){
			if(i != influncer){
				if(followingMatrix[influncer][i] == true || followingMatrix[i][influncer] == false){
					throw new IllegalArgumentException("Wrong input");
				}
			}
		}
		return influncer;
	}
}
