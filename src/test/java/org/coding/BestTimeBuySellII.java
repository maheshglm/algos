package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
public class BestTimeBuySellII {


    //peak valley approach

    //This on the intution of from 1st day, think I am greater than yesterday.
    //if yes, profit is difference between todays price and yesterday price
    private int solution1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    //O(N) and O(1)
    private int solution(int[] prices) {
        int i = 0;
        int n = prices.length;

        int buy = 0;
        int sell = 0;
        int profit = 0;
        while (i < n - 1) {
            //keep looping until u find hike in price for the next day
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = prices[i];

            //keep looping until u find fall in price for the next day
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
    }

    @Test
    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        //Output: 7
        //Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        //Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    }

    @Test
    public void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        //Output: 4
        //Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        //Note that you cannot buy on day 1, buy on day 2 and sell them later,
        //as you are engaging multiple transactions at the same time. You must sell before buying again.
    }

    @Test
    public void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        //0
        //Explanation: In this case, no transaction is done, i.e., max profit = 0.

    }

}
