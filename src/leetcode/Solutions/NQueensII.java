package leetcode.Solutions;

public class NQueensII {
	private int count = 0;
    public int totalNQueens(int n) {
      if(n <= 0){
      	return 0;
      }
      
      int[] arr = new int[n];
      for(int i=0; i<n; i++){
      	arr[i] = -1;
      }
            
      cal(0, n ,arr);
      
      return count;
  }
  private void cal(int index, int n, int[] arr){
  	if(n == index){
  		count++;
  		return;
  	}
  	
  	for(int i=0; i<n; i++){
  		arr[index] = i;
  		if(isValid(arr, index)){
  			cal(index+1, n, arr);
  		}
  		arr[index] = -1;
  	}
  }
  
  private boolean isValid(int[] arr, int index){
  	if(index == 0){
  		return true;
  	}
  	
  	for(int i=0; i<index; i++){
  		if(arr[i] == arr[index]){
  			return false;
  		}
  		
  		if(Math.abs(i-index) == Math.abs(arr[i] - arr[index])){
  			return false;
  		}
  	}
  	return true;
  }
}
