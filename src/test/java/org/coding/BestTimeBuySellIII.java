package org.coding;

//https://www.youtube.com/watch?v=gVavspgEHyM - Good explanation
//https://www.youtube.com/watch?v=oDhu5uGq_ic
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//https://www.youtube.com/watch?v=37s1_xBiqH0
public class BestTimeBuySellIII {

    //max profit when atmost 2 transactions

    //Overall, we run an iteration over the sequence of prices.
    //
    //Over the iteration, we calculate 4 variables which correspond to the costs or the profits of each action respectively, as follows:
    //
    //t1_cost: the minimal cost of buying the stock in transaction #1.
    //The minimal cost to acquire a stock would be the minimal price value that we have seen so far at each step.
    //
    //t1_profit: the maximal profit of selling the stock in transaction #1.
    //Actually, at the end of the iteration, this value would be the answer for the first problem in the series,
    //i.e. Best Time to Buy and Sell Stock.
    //
    //t2_cost: the minimal cost of buying the stock in transaction #2,
    //while taking into account the profit gained from the previous transaction #1.
    //One can consider this as the cost of reinvestment. Similar with t1_cost, we try to find the lowest price so far,
    //which in addition would be partially compensated by the profits gained from the first transaction.
    //
    //t2_profit: the maximal profit of selling the stock in transaction #2.
    //With the help of t2_cost as we prepared so far, we would find out the maximal profits with at most two transactions at each step.

    private int solution(int[] prices) {
        int fBuy = Integer.MIN_VALUE;
        int sBuy = Integer.MIN_VALUE;

        int fSell = 0;
        int sSell = 0;

        for (int price : prices) {
            fBuy = Math.max(fBuy, -price);
            fSell = Math.max(fSell, fBuy + price);

            sBuy = Math.max(sBuy, fSell - price);
            sSell = Math.max(sSell, sBuy + price);
        }
        return sSell;
    }

}
