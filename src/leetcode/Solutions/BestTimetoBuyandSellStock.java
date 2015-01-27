package leetcode.Solutions;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <2){
        	return 0;
        }
        
        int min = prices[0];
        int maxp = 0;
        for(int i=1; i<prices.length; i++){
        	if(prices[i] < min){
        		min = prices[i];
        	}else{
        		int ded = prices[i] - min;
        		if(ded > maxp){
        			maxp = ded;
        		}
        	}
        }
        return maxp;
        
        
    }
}
