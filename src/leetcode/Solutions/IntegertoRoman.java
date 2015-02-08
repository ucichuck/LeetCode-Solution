package leetcode.Solutions;

public class IntegertoRoman {
	public String intToRoman(int num) {
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L","XL","X","IX","V","IV","I"}; 
        
        StringBuilder res = new StringBuilder();
        int i=0;
        while(num > 0){
        	int k = num / values[i];
        	for(int j=0; j< k; j++){
        		res.append(strings[i]);
        		num -= values[i];
        	}
        	i++;
        }
        return res.toString();
    }
}
