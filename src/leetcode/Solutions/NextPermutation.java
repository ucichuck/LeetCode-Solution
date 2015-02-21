package leetcode.Solutions;

public class NextPermutation {
  public void nextPermutation(int[] num) {
  if(num.length<=1){
  	return;
  }
  
  int index = num.length-1;
  
  while(index > 0){
  	if(num[index-1] < num[index]){
  		break;
  	}
  	index --;
  }
  
 
  if(index > 0){
       index --;
  	int end = num.length-1;
  	while(index < end){
  		if(num[end] > num[index]){
  			int tmp = num[index];
  			num[index] = num[end];
  			num[end] = tmp;
  			index++;
  			break;
  		}
  		end--;
  	}
  }
  int end = num.length-1;
  while(index < end){
  	int tmp = num[end];
  	num[end] = num[index];
  	num[index] = tmp;
  	end--;
  	index ++;
  }
}
}
