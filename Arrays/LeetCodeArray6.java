package Arrays;
/*
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
/*Logic:eg[7,1,5,3,6,4]
 * 1.min=Max value,diff/profit=0,j will increase from 0.
 * Find min between two elements.prices[j]-min is the profit.
 */
public class LeetCodeArray6 {

	public int maxProfit(int[] prices) {
		int diff=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++) {
			min=Math.min(min,prices[i]);//Find min between current min and prices[i]
			if((prices[i]-min)>diff) {
				//check if current profit >old profit.if yes,diff=current profit
				diff=prices[i]-min;
			}
		}
		return diff;
	}
	
	public static void main(String[] args) {
		LeetCodeArray6 la6=new LeetCodeArray6();
		int arr[]= {7,5,4,9};
		
		System.out.println(la6.maxProfit(arr));
		//ans:1994

	}
	 
}
