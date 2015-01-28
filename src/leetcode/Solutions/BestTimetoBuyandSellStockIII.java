package leetcode.Solutions;

public class BestTimetoBuyandSellStockIII {
	 public int maxProfit(int[] prices) {
	    	if(prices == null || prices.length <2){
	    	return 0;
	    	}
	    	int[] arr1 = new int[prices.length];
	    	int min = prices[0];
	    	arr1[0] = 0;
	    	int profit = 0;
	    	for(int i=1; i<prices.length ; i++ ){
	    		if(prices[i] < min){
	    			min = prices[i];
	    			
	    		}else{
	    			profit = Math.max(profit,  prices[i] - min);
	    		}
	    		arr1[i] = profit;
	    	}
	    	int[] arr2 = new int[prices.length];
	    	int max = prices[prices.length-1];
	    	arr2[prices.length-1] = 0;
	    	profit = 0;
	    	for(int i=prices.length-2; i>=0; i--){
	    		if(prices[i] > max){
	    			max = prices[i];
	    		}else{
	    			profit = Math.max(profit, max - prices[i]);
	    		}
	    		arr2[i] = profit;
	    	}
	    	
	    	int res = 0;
	    	for(int i=0; i< prices.length; i++){
	    		res = Math.max(arr1[i] + arr2[i], res);
	    	}
	    	return res;
	    }
}
